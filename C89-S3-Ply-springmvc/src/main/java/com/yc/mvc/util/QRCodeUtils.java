package com.yc.mvc.util;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;
 
import javax.imageio.ImageIO;
 
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
   
    public class QRCodeUtils {
        private static final String CHARSET = "utf-8";
        private static final String FORMAT_NAME = "JPG";
        // 二维码尺寸
        private static final int QRCODE_SIZE = 300;
        // LOGO宽度
        private static final int WIDTH = 60;
        // LOGO高度
        private static final int HEIGHT = 60;
        private static BufferedImage createImage(String content, String imgPath,
                                                 boolean needCompress) throws Exception {
            Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
            //指定纠错等级
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //解析设置编码方式为utf-8，CHARSET常量值为utf-8
            hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
            //边距
            hints.put(EncodeHintType.MARGIN, 1);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            //将BitMatrix转换成BufferedImage
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    //设置颜色，可设置为想要的颜色
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                            : 0xFFFFFFFF);
                }
            }
            if (imgPath == null || "".equals(imgPath)) {
                return image;
            }
            // 插入图片
            QRCodeUtils.insertImage(image, imgPath, needCompress);
            return image;
        }

       
        private static void insertImage(BufferedImage source, String imgPath,
                                        boolean needCompress) throws Exception {
            File file = new File(imgPath);
            if (!file.exists()) {
                System.err.println(""+imgPath+"   该文件不存在！");
                return;
            }
            Image src = ImageIO.read(new File(imgPath));
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            if (needCompress) { // 压缩LOGO
                if (width > WIDTH) {
                    width = WIDTH;
                }
                if (height > HEIGHT) {
                    height = HEIGHT;
                }
                Image image = src.getScaledInstance(width, height,
                        Image.SCALE_SMOOTH);
                BufferedImage tag = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(image, 0, 0, null); // 绘制缩小后的图
                g.dispose();
                src = image;
            }
            // 插入LOGO  创建一个  Graphics2D，可以将它绘制到此BufferedImage中
            Graphics2D graph = source.createGraphics();
            int x = (QRCODE_SIZE - width) / 2;
            int y = (QRCODE_SIZE - height) / 2;
        /*绘制图片，参数分别是加载图像，x，y是指定绘制图像矩形左上角的位置，width是
                       是指定绘制图像矩形的宽，width是指定绘制图像矩形的高,最后那个是绘制图像容器，这里设为null*/
            graph.drawImage(src, x, y, width, height, null);
            Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
            //设garphics2D 上下文设置 Stroke
            graph.setStroke(new BasicStroke(3f));
            //使用当前 Graphics2D 上下文的设置勾画 Shape 的轮廓。
            graph.draw(shape);
            graph.dispose();
        }

       
        public static String encode(String content, String imgPath, String destPath,
                                    boolean needCompress) throws Exception {
            BufferedImage image = QRCodeUtils.createImage(content, imgPath,
                    needCompress);
            mkdirs(destPath);
            String file = new Random().nextInt(99999999)+".jpg";
            ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
            return file;
        }

       
        public static void mkdirs(String destPath) {
            File file =new File(destPath);
            //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
            if (!file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
        }

        
        public static void encode(String content, String imgPath, String destPath)
                throws Exception {
            QRCodeUtils.encode(content, imgPath, destPath, false);
        }

        
        public static void encode(String content, String destPath,
                                  boolean needCompress) throws Exception {
            QRCodeUtils.encode(content, null, destPath, needCompress);
        }

      
        public static void encode(String content, String destPath) throws Exception {
            QRCodeUtils.encode(content, null, destPath, false);
        }

       
        public static void encode(String content, String imgPath,
                                  OutputStream output, boolean needCompress) throws Exception {
            BufferedImage image = QRCodeUtils.createImage(content, imgPath,
                    needCompress);
            ImageIO.write(image, FORMAT_NAME, output);
        }

       
        public static void encode(String content, OutputStream output)
                throws Exception {
            QRCodeUtils.encode(content, null, output, false);
        }

        
        public static String decode(File file) throws Exception {
            BufferedImage image;
            image = ImageIO.read(file);
            if (image == null) {
                return null;
            }
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                    image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result;
            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
            result = new MultiFormatReader().decode(bitmap, hints);
            String resultStr = result.getText();
            return resultStr;
        }

        public static String decode(String path) throws Exception {
            return QRCodeUtils.decode(new File(path));
        }

	
    }
