package ChatGpt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FiletoXML {
public static void main(String[] args) throws IOException 
	{  
	
		try {    
			// Read the text file
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Ashfaq PC\\Downloads\\file1.txt"));
			String line =" ";
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();

			// Create the XML document
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element rootElement = doc.createElement("data");
			doc.appendChild(rootElement);
			Element textElement = doc.createElement("text");
			textElement.setTextContent(sb.toString());
			rootElement.appendChild(textElement);

			// Save the XML file
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			FileWriter writer = new FileWriter("C:\\Users\\Ashfaq PC\\Downloads\\output.xml");
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			writer.close();
			System.out.println("XML file saved successfully");
		}
		catch (Exception e){
			e.printStackTrace();

		}
	
}
}
