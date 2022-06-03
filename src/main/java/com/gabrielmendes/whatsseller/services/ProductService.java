package com.gabrielmendes.whatsseller.services;

import com.gabrielmendes.whatsseller.entities.Product;
import com.gabrielmendes.whatsseller.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findByBarcode(String barcode){
        Optional<Product> product = productRepository.findById(barcode);

        return product.orElse(null);
    }

}
