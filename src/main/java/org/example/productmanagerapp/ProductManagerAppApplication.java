package org.example.productmanagerapp;

import org.example.productmanagerapp.entities.Product;
import org.example.productmanagerapp.entities.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductManagerAppApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductManagerAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Computer", 4300.0, 3));
        productRepository.save(new Product(null, "Phone", 7000.0, 10));
        productRepository.save(new Product(null, "Printer", 3000.0, 5));
        List<Product> Products = productRepository.findAll();
        Products.forEach(p->{System.out.println(p.toString());});
        Product Product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************++***+");
        System.out.println("Product ID: " + Product.getId());
        System.out.println("Product Name: " + Product.getName());
        System.out.println("Product Price: " + Product.getPrice());
        System.out.println("Product Quantity: " + Product.getQuantity());
        System.out.println("************++***+");



    }
}
