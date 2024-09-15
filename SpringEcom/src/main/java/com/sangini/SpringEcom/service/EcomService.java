package com.sangini.SpringEcom.service;

import com.sangini.SpringEcom.model.Product;
import com.sangini.SpringEcom.repo.EcomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EcomService {

    @Autowired
    EcomRepo repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }


    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(Product product) {
        repo.deleteById(product.getId());
    }

    public List<Product> getProductsFromKeyword(String keyword) {
        return repo.findProductByKeyWord(keyword);
    }
}
