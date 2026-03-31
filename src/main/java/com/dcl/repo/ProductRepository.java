package com.dcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
