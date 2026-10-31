package ChatGpt;
//java code to take string and convert into pdf
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class StringtoPDF {

	
	public static void main(String[] args) {
        // Replace "HELLO_WORLD" with the string you want to convert to PDF
        String text = "HELLO WORLD this is a pdf demo";
        // Replace "output.pdf" with the desired output file name
        String fileName = "output.pdf";

        try {
            // Create a new document
            Document document = new Document();
            // Create a PDF writer for the document
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            // Open the document for writing
            document.open();
            // Add the string to the document as a paragraph
            document.add(new Paragraph(text));
            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
