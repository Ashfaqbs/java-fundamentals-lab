import os
import subprocess
import tempfile
import zipfile
from urllib.parse import urljoin, urlparse
from html import escape  # Import the escape function
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import letter
import requests
from bs4 import BeautifulSoup
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet

# Check if a URL points to a directory
def is_directory(url):
    response = requests.head(url)
    return response.headers.get('content-type') == 'text/html'

# List all JAR and POM files in a directory
def list_directory_contents(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    links = [a['href'] for a in soup.find_all('a', href=True)]
    return [urljoin(url, link) for link in links if link.endswith('.jar') or link.endswith('.pom')]

# Find the sources JAR from the URL
def find_sources_jar(url):
    if is_directory(url):
        contents = list_directory_contents(url)
        for content in contents:
            if content.endswith('-sources.jar'):
                return content
    else:
        if url.endswith('-sources.jar'):
            return url
        directory = url.rsplit('/', 1)[0] + '/'
        contents = list_directory_contents(directory)
        for content in contents:
            if content.endswith('-sources.jar'):
                return content
    return None

# Download a file from a URL
def download_file(url, filename):
    with requests.get(url, stream=True) as r:
        r.raise_for_status()
        with open(filename, 'wb') as f:
            for chunk in r.iter_content(chunk_size=8192):
                f.write(chunk)

# Extract Java source files from a JAR
def extract_java_files(zip_filename):
    java_files = {}
    with zipfile.ZipFile(zip_filename, 'r') as zip_ref:
        for file in zip_ref.namelist():
            if file.endswith('.java'):
                with zip_ref.open(file) as java_file:
                    content = java_file.read().decode('utf-8', errors='ignore')
                    java_files[file] = content
    return java_files

# Create a PDF from a list of (title, content) pairs
def create_pdf_from_text(text_list, pdf_filename):
    """
    Create a PDF from a list of (title, content) pairs.
    
    Args:
        text_list (list): List of tuples containing (title, content) pairs.
        pdf_filename (str): Output PDF filename.
    """
    doc = SimpleDocTemplate(pdf_filename, pagesize=letter)
    styles = getSampleStyleSheet()
    story = []

    for title, content in text_list:
        # Escape the title to prevent parsing issues
        story.append(Paragraph(escape(title), styles['Heading1']))
        story.append(Spacer(1, 12))

        # Process each line of the content
        for line in content.splitlines():
            # Escape each line to prevent parsing issues
            escaped_line = escape(line)
            story.append(Paragraph(escaped_line, styles['Normal']))
        story.append(Spacer(1, 12))

    doc.build(story)

# Find the main JAR (non-sources, non-javadoc) from the URL
def find_main_jar(url):
    if is_directory(url):
        contents = list_directory_contents(url)
        for content in contents:
            if content.endswith('.jar') and not content.endswith('-sources.jar') and not content.endswith('-javadoc.jar'):
                return content
    else:
        if url.endswith('.jar') and not url.endswith('-sources.jar') and not url.endswith('-javadoc.jar'):
            return url
    return None

# Check if Java is installed
def is_java_installed():
    try:
        subprocess.run(['java', '-version'], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        return True
    except FileNotFoundError:
        return False

# Disassemble class files using javap
def disassemble_class_files(class_files):
    disassembled = {}
    for class_file in class_files:
        result = subprocess.run(['javap', '-c', class_file], capture_output=True, text=True)
        disassembled[class_file] = result.stdout
    return disassembled

# Main function to process the Maven URL and generate the PDF
def main(maven_url, output_pdf):
    # Try to find and process the sources JAR
    sources_jar_url = find_sources_jar(maven_url)
    if sources_jar_url:
        print(f"Found sources JAR: {sources_jar_url}")
        with tempfile.TemporaryDirectory() as temp_dir:
            sources_jar = os.path.join(temp_dir, 'sources.jar')
            download_file(sources_jar_url, sources_jar)
            java_files = extract_java_files(sources_jar)
            text_list = [(filename, content) for filename, content in java_files.items()]
            create_pdf_from_text(text_list, output_pdf)
            print(f"PDF created successfully: {output_pdf}")
    else:
        # Fallback to the main JAR if sources are unavailable
        print("Sources JAR not found. Attempting to use main JAR...")
        main_jar_url = find_main_jar(maven_url)
        if main_jar_url:
            print(f"Found main JAR: {main_jar_url}")
            if not is_java_installed():
                print("Java is not installed. Cannot disassemble class files.")
                return
            with tempfile.TemporaryDirectory() as temp_dir:
                main_jar = os.path.join(temp_dir, 'main.jar')
                download_file(main_jar_url, main_jar)
                with zipfile.ZipFile(main_jar, 'r') as zip_ref:
                    zip_ref.extractall(temp_dir)
                class_files = [os.path.join(root, file) for root, _, files in os.walk(temp_dir) 
                               for file in files if file.endswith('.class')]
                disassembled = disassemble_class_files(class_files)
                text_list = [(os.path.relpath(class_file, temp_dir), content) 
                             for class_file, content in disassembled.items()]
                create_pdf_from_text(text_list, output_pdf)
                print(f"PDF created from disassembled class files: {output_pdf}")
        else:
            print("Main JAR not found. Cannot proceed.")

# Entry point
if __name__ == "__main__":
    maven_url = input("Enter the Maven repository link: ").strip()
    output_pdf = input("Enter the output PDF filename: ").strip()
    main(maven_url, output_pdf)
    
    
    
    
    
# C:\tmp\jar-to-pdf>C:/Users/ashfa/AppData/Local/Programs/Python/Python312/python.exe c:/tmp/jar-to-pdf/app.py
# Enter the Maven repository link: https://repo1.maven.org/maven2/io/kubernetes/client-java/22.0.0/client-java-22.0.0.jar
# Enter the output PDF filename: k8sclean.jar
# Found sources JAR: https://repo1.maven.org/maven2/io/kubernetes/client-java/22.0.0/client-java-22.0.0-sources.jar
# PDF created successfully: k8sclean.jar