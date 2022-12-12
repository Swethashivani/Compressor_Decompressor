/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.*;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author shivenduac
 */
public class decompressor {
    public static void GzipDecompressor(File file) throws IOException{
       
        String fileDirectory= file.getParent();
        FileInputStream fis= new FileInputStream(file);
        GZIPInputStream gzipIS= new GZIPInputStream(fis);
        String name = file.getName();
        if (name.indexOf(".") > 0)
            name = name.substring(0, name.lastIndexOf("."));
        FileOutputStream fos=new  FileOutputStream(fileDirectory+ "/" + name);
        
        byte[] buffer=new byte[1024];
        
        int len;
        
        while((len=gzipIS.read(buffer)) !=-1){
            System.out.println("length of file"+len);
            fos.write(buffer, 0,len);     
        }
        gzipIS.close();
        fis.close();
        fos.close();     
    }
    
    public static void ZipDecompressor(File file) throws IOException{
        FileInputStream fis= new FileInputStream(file);
        ZipInputStream zis = new ZipInputStream(fis);
        byte[] buffer=new byte[1024];
        ZipEntry zipEntry = zis.getNextEntry();
       
        File newFile = newFile(new File(file.getParent()), zipEntry);
        while (zipEntry!= null) {
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while((len = zis.read(buffer)) >0 ) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }
    
    
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
    
    
    public static void main(String[] args) throws IOException{
        File path=new File("/Users/saratchandra/Desktop/Compressedfile.gz");
        GzipDecompressor(path);
        //System.out.print();
        
    }  
}