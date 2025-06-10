package com.vishwas.controller;

import com.vishwas.entity.Product;
import com.vishwas.service.ProService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "Product Controller" ,description = "Add, Update,del,update")
@RestController
@RequiredArgsConstructor
public class ProController {

    private final ProService proService;

    @GetMapping("/product")
    @Operation(summary = "Get all the products")
    public List<Product> allProducts(){
       return proService.allproduct();
    }
    @GetMapping("/product/{id}")
    public  Optional<Product> productById(@PathVariable Integer id){
        return proService.productbyid(id);
    }
    @PostMapping("/product")
    public void addProduct(@RequestBody Product p){
        proService.addProduct(p);
    }
    @DeleteMapping("/product/{id}")
    public  void delProduct(@PathVariable Integer id){
        proService.delProduct(id);
    }
    @PutMapping("/product")
    public void updateProduct(@RequestBody Product p){
         proService.updateProduct(p);
    }
}
