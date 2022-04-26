package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.exceptions.InvalidURLException;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class BarcodeService {

    private MultiFormatReader reader = new MultiFormatReader();
    public String readFromUrl(String urlPath){
        try {
            URL url = new URL(urlPath);
            ImageIO.setUseCache(false);
            BufferedImage bfImage = ImageIO.read(url);
            BinaryBitmap bitmapImage = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bfImage)));

            //Tries to find the barcode on the horizontal
            String barcodeNumber = "";
            int rotateTimes = 0;
            while (barcodeNumber.equals("") && rotateTimes < 2){
                barcodeNumber = decodeImage(bitmapImage);
                if(barcodeNumber.equals("")){
                    bitmapImage = bitmapImage.rotateCounterClockwise();
                    if(rotateTimes == 1){
                        bitmapImage = bitmapImage.rotateCounterClockwise();
                    }
                }
                rotateTimes++;
            }

            return barcodeNumber;
        } catch (IOException e){
            throw new InvalidURLException("Invalid image path: "+urlPath);
        }
    }

    private String decodeImage(BinaryBitmap bitmapImage){
        try {
            Result result = reader.decode(bitmapImage);
            return result.getText();
        } catch (NotFoundException e){
            return "";
        }
    }

}
