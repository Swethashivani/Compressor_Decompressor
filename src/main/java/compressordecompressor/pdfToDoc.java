/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfImageType;
import javax.imageio.ImageIO;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;


/**
 *
 * @author saratchandra
 */
public class pdfToDoc {
    public static boolean convertPdfToDoc(File file) throws IOException {
       PdfDocument doc = new PdfDocument();
        doc.loadFromFile(file.getAbsolutePath());
         String name = file.getName();
         if (name.indexOf(".") > 0)
            name = name.substring(0, name.lastIndexOf("."));
        doc.saveToFile(file.getParent()+"/"+ name +".docx"  ,FileFormat.DOCX);
        doc.close();
       return true;   
        
    }
}
