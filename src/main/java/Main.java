import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

        // ^^ Above code simply makes a pdf that is a blank 1-page document. ^^
        //====================================================================//

//        File oldFile = new File("C:\\PDF\\sample.pdf");
//        PDDocument document = PDDocument.load(oldFile);
//        if (document.isEncrypted()) {
//            document.setAllSecurityToBeRemoved(true); // This will remove all security from the document
//        }
//        document.addPage(new PDPage());
//        document.save("C:\\PDF\\myNewPDF.pdf");
//
//        String newFilePath = "C:\\PDF\\myNewPDF.pdf";
//        document.save(newFilePath); // Save the new document
//
//        String originalFileName = oldFile.getName(); // This extracts the file name
//        String newFileName = new File(newFilePath).getName();
//
//        System.out.println("Old File: " + originalFileName);
//        System.out.println("New File: " + newFileName);
//        document.close();
        // ^^ Above code simply appends a blank page to a pdf. ^^
        //====================================================================//

//        File oldFile = new File("C:\\PDF\\sample.pdf");
//        PDDocument document = PDDocument.load(oldFile);
//        if (document.isEncrypted()) {
//            document.setAllSecurityToBeRemoved(true); // This will remove all security from the document
//        }
//
//        Splitter splitter = new Splitter();
//        List<PDDocument> splitPages = splitter.split(document);
//        int num = 1;
//        for(PDDocument i : splitPages){
//            i.save("C:\\PDF\\output\\split_0" + num + ".jpg");
//            num++;
//            i.close();
//        }
//        System.out.println("Split " + (num-1) + " pages!");


        // ^^ Above code simply splits a large document to a bunch of pdf(s) ^^
        //====================================================================//

        File oldFile = new File("C:\\PDF\\sample.pdf");
        try (PDDocument document = PDDocument.load(oldFile)) {
            if (document.isEncrypted()) {
                document.setAllSecurityToBeRemoved(true); // This will remove all security from the document
            }

            PDFRenderer renderer = new PDFRenderer(document);
            int pageCount = document.getNumberOfPages(); // Basically .length
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 300);
                File outputFile = new File("C:\\PDF\\output\\split_" + String.format("%02d", i + 1) + ".png"); // Change extension to .jpg for JPEG
                ImageIO.write(image, "PNG", outputFile); // Use "JPEG" instead of "PNG" for JPEG format
            }
            System.out.println("Split and saved " + pageCount + " pages as images!");
        }



    }
}
