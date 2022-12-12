/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author shivenduac
 */
public class compressor {
    public static void GzipCompressor(File file) throws IOException{
        String filedirectory= file.getParent();
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(filedirectory+"/" + file.getName()+".gz");
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);
        
        byte[] buffer =new byte[1024];
        int len;
        
        while((len=fis.read(buffer)) != -1){
            gzipOS.write(buffer,0,len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
    }
    
    public static void ZipCompressor(File file) throws IOException {
        System.out.print(file.exists());
        
        FileInputStream fis= new FileInputStream(file);
        ZipEntry ZipEntry= new ZipEntry(file.getName());
        FileOutputStream fos = new FileOutputStream(file.getParent() +"/"+ file.getName() + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        zipOut.putNextEntry(ZipEntry);
        byte[] buffer=new byte[1024];
        
        int len;
        
        while((len=fis.read(buffer)) != -1){
            zipOut.write(buffer, 0, len);
        }
        zipOut.close();
        fis.close();
        fos.close();   
    }
    public static void main(String[] args) throws IOException{
        File path=new File("/Users/saratchandra/Desktop/Compressedfile");
        GzipCompressor(path);
    }
    
}