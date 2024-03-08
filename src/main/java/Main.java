import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello");
//        PDDocument document = new PDDocument();
//        PDPage firstPage = new PDPage();
//
//        document.addPage(firstPage);
//        document.save( "C:\\PDF\\mypdf.pdf"); //Make sure you have the dir
//        System.out.println("PDF MADE!");
//        document.close();

        //====================================================================
        // ^^ Above code simply makes a pdf that is a blank 1-page document. ^^




        File oldFile = new File("C:\\PDF\\sample.pdf");
        PDDocument document = PDDocument.load(oldFile);
        if (document.isEncrypted()) {
            document.setAllSecurityToBeRemoved(true); // This will remove all security from the document
        }
        document.addPage(new PDPage());
        document.save("C:\\PDF\\myNewPDF.pdf");

        String newFilePath = "C:\\PDF\\myNewPDF.pdf";
        document.save(newFilePath); // Save the new document

        String originalFileName = oldFile.getName(); // This extracts the file name
        String newFileName = new File(newFilePath).getName();

        System.out.println("Old File: " + originalFileName);
        System.out.println("New File: " + newFileName);
        document.close();


    }
}
