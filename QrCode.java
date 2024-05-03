package com.lanou;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class QrCode {
    /*
    *生成二维码的方法*/
    public static void qrcode(String contents,String path){
        //定义二维码的宽和高
        int width = 400;
        int height = 400;
        //定义生成二维码图片的后缀
        String format="jpg";

        //设置二维码的参数
        HashMap map = new HashMap<>();
        //二维码的级别
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码的字符集
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //设置二维码的外边距
        map.put(EncodeHintType.MARGIN,4);

        try {
            //zxing核心对象,用来生成二维码
            MultiFormatWriter writer = new MultiFormatWriter();
            //writer.encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints);
            //生成位矩阵对象
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height, map);
            Path paths = new File(path).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,paths);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        qrcode("https://www.bilibili.com","D:/1test/b.jpg");
    }
}
