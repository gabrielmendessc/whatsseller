package com.gabrielmendes.whatsseller.repositories;

import com.gabrielmendes.whatsseller.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
