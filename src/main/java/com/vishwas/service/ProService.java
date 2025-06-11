package com.vishwas.service;

import com.vishwas.entity.Product;
import com.vishwas.repo.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProService {
    @Autowired
    private ProRepo repo;
    public List<Product> allproduct() {
        return repo.findAll();
    }

    public Optional<Product> productbyid(Integer id) {
        if (repo.existsById(id)){
            return repo.findById(id);
        }
        else {
            throw new RuntimeException("id not found");
        }
    }

    public void updateProduct(Product p) {

       if (repo.existsById(p.getId())){
            repo.save(p);
       }
       else{
           throw new RuntimeException("no product found of this id");
       }

    }

    public void delProduct(Integer id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
        else{
            throw new RuntimeException("no product found of this id");
        }
    }

    public void addProduct(Product p) {
        repo.save(p);
    }
}
