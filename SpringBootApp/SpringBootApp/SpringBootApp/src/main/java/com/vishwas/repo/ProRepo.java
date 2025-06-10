package com.vishwas.repo;

import com.vishwas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepo extends JpaRepository<Product,Integer> {
}
