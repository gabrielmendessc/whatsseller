package com.gabrielmendes.whatsseller.entities.choices.services;

import com.gabrielmendes.whatsseller.entities.choices.MenuChoice;
import com.gabrielmendes.whatsseller.entities.choices.ScannerChoice;
import com.gabrielmendes.whatsseller.services.BarcodeService;
import com.gabrielmendes.whatsseller.services.ProductService;
import com.gabrielmendes.whatsseller.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    @Autowired
    private ResponseService responseService;
    @Autowired
    private BarcodeService barcodeService;
    @Autowired
    private ProductService productService;

    public MenuChoice instantiateMenuChoice(){
        return new MenuChoice(responseService, barcodeService);
    }

    public MenuChoice instantiateNoChoice(){
        return new MenuChoice(responseService, barcodeService);
    }

    public ScannerChoice instantiateScannerChoice(){
        return new ScannerChoice(responseService, barcodeService, productService);
    }
}
