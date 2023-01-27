package com.pedidos.api.dao;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import javax.imageio.ImageIO;
 
import java.util.Hashtable;
 
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
 
 /**
     * Generar código QR y convertir código QR a cadena base64
  */
public class MatrixToImageWriter {
     private static final int BLACK = 0xFF000000;
     private static final int WHITE = 0xFFFFFFFF;
 
     private MatrixToImageWriter() {
     }
 
     
     /**
             * Generar código QR
      *
      * @param content
      * @return
      * @throws Exception
      */
     public static InputStream createQrcodeImage(String content) throws Exception {
    	 int ancho  = 200; // ancho de la imagen del código QR
                   int height = 200; // altura de la imagen del código QR
                   String format = "jpg"; // Formato de imagen del código QR
         Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
                   hints.put (EncodeHintType.CHARACTER_SET, "utf-8"); // codificación del juego de caracteres utilizada para el contenido
         BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                 BarcodeFormat.QR_CODE, ancho, height, hints);
         BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
         InputStream is=MatrixToImageWriter.toInputStream(image);
         return is;
 
     }
     
     /**
             * @Description: Convertir a una cadena codificada en base64 basada en la dirección de la imagen
      * @Author: 
      * @CreateTime: 
      * @return
      */
     public static String getImageStr(InputStream inputStream) {
         byte[] data = null;
         try {
             data = new byte[inputStream.available()];
             inputStream.read(data);
             inputStream.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
                   // cifrado
         return "";
     }
     
     public static BufferedImage toBufferedImage(BitMatrix matrix) {
         int width = matrix.getWidth();
         int height = matrix.getHeight();
         BufferedImage image = new BufferedImage(width, height,
                 BufferedImage.TYPE_INT_RGB);
         for (int x = 0; x < width; x++) {
             for (int y = 0; y < height; y++) {
                 image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
             }
         }
         return image;
     }
     
     public static InputStream toInputStream(BufferedImage image) throws Exception {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         ImageIO.write(image, "jpg", os);
         InputStream is = new ByteArrayInputStream(os.toByteArray());
         return is;
     }
 
     public static void writeToFile(BitMatrix matrix, String format, File file)
             throws IOException {
         BufferedImage image = toBufferedImage(matrix);
         if (!ImageIO.write(image, format, file)) {
           throw new IOException("Could not write an image of format "
                     + format + " to " + file);
         }
     }
 
     public static void writeToStream(BitMatrix matrix, String format,
             OutputStream stream) throws IOException {
         BufferedImage image = toBufferedImage(matrix);
         if (!ImageIO.write(image, format, stream)) {
             throw new IOException("Could not write an image of format " + format);
         }
     }
     
     
 
     public static void main(String[] args) throws Exception {
    	 try{
	    	  String text = "http://www.baidu.com"; // Contenido del código QR
	          int ancho= 200; // ancho de la imagen del código QR
	          int height = 200; // altura de la imagen del código QR
	          String format = "jpg"; // Formato de imagen del código QR
	
	         Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
	          hints.put (EncodeHintType.CHARACTER_SET, "utf-8"); // codificación del juego de caracteres utilizada para el contenido
	
	         BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
	                 BarcodeFormat.QR_CODE, ancho, height, hints);
	         BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
	         InputStream is=MatrixToImageWriter.toInputStream(image);
	          // Genera código QR para guardar la ruta de la computadora
	         File outputFile = new File("/home/sistem33/Documents/Guias");
	        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
         } catch (Exception e) {
        	          System.out.println ("Exception ==" + e.getMessage ());
 			e.printStackTrace();
 		}
     }
 
 
 


}
