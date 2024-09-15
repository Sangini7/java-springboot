package com.sangini.SpringEcom.controller;


import com.sangini.SpringEcom.model.Product;
import com.sangini.SpringEcom.service.EcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class EcomController {

    @Autowired
    EcomService ecomService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(ecomService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProducts(@PathVariable int productId) {

        Product product = ecomService.getProduct(productId);
        if (product != null) {
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        Product product = ecomService.getProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addImage(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

        Product savedProduct;
        try {
            savedProduct = ecomService.addOrUpdateProduct(product, imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateImage(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

        Product savedProduct;
        try {
            savedProduct = ecomService.addOrUpdateProduct(product, imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable int id) {

        Product product = ecomService.getProduct(id);

        if (product != null) {
            ecomService.deleteProduct(product);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> deleteImage(@RequestParam String keyword) {

        return new ResponseEntity<>(ecomService.getProductsFromKeyword(keyword), HttpStatus.OK);


    }

}
