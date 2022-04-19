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

    public String readFromUrl(String urlPath){
        try {
            URL url = new URL(urlPath);
            BufferedImage bfImage = ImageIO.read(url);
            BinaryBitmap bitmapImage = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bfImage)));

            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmapImage);

            return result.getText();
        } catch (IOException e){
            throw new InvalidURLException("Invalid image path: "+urlPath);
        } catch (NotFoundException e){
            return "";
        }
    }

}
