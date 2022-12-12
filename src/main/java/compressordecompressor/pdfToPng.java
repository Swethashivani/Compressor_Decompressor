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

/**
 *
 * @author saratchandra
 */
public class pdfToPng {
    public static boolean convertPdfToPng(File file) throws IOException {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(file.getAbsolutePath());
        String name = file.getName();
        if (name.indexOf(".") > 0)
            name = name.substring(0, name.lastIndexOf("."));
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            BufferedImage image = pdf.saveAsImage(i);
            File newfile = new File(file.getParent() + "/" + String.format((name + "-%d.png"), i));
            ImageIO.write(image, "PNG", newfile);
        }
        pdf.close();
        return true;
    }
}
