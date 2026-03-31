package com.dcl.service;

import java.util.List;

import com.dcl.entity.Products;
import com.dcl.request.ProductRequest;

public interface ProductService {
 Products saveProduct(ProductRequest request);
 Products getProduct(Integer productId);
 Products updateProduct(Integer productId,ProductRequest update);
 void deleteProducts(Integer id);
 List<Products> getAllProducts();
}
