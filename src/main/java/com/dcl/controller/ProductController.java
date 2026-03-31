
package com.dcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.entity.Products;
import com.dcl.request.ProductRequest;
import com.dcl.service.ProductService;

@RestController

@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
   @PostMapping("/save")
   ResponseEntity<?> saveProduct(@RequestBody ProductRequest request) {
	   Products p = pservice.saveProduct(request);
	   
	   return  new ResponseEntity<Products>(p, HttpStatus.CREATED);
   }
   @GetMapping("/get/{productId}")
    ResponseEntity<?> getProduct( @PathVariable Integer productId ) {
	   Products p = pservice.getProduct(productId);
	   if(p!=null) {
	   return new ResponseEntity<Products>(p,HttpStatus.OK);
   }
   else {
	   return new ResponseEntity<String>("Product Not Found", HttpStatus.NOT_FOUND);
   }
   }
   
   
   @GetMapping("/get")
   ResponseEntity<?> getAllProducts(){
	   List<Products> prod = pservice.getAllProducts();
	   if(prod!=null&&!prod.isEmpty()) {
	   return new ResponseEntity<List<Products>>(prod, HttpStatus.OK);
   }
	   else {
		   return new ResponseEntity<String>("Products not available", HttpStatus.NOT_FOUND);
	   }
   

}
   @PutMapping("/update/{id}")
   ResponseEntity<?> updateProduct(@PathVariable Integer id,@RequestBody ProductRequest update){
	   Products p = pservice.updateProduct(id, update);
	   if(p!=null) {
		   return new ResponseEntity<Products>(p, HttpStatus.OK);
	   }
	   else {
		  
		   return new ResponseEntity<String>("Product not updated", HttpStatus.NOT_FOUND);
	   }
   
   }
   @DeleteMapping("/delete/{id}")
   ResponseEntity<?> deleteProduct(@PathVariable Integer id){
	   pservice.deleteProducts(id);
	   return new ResponseEntity<String>("Product Deleted Succesfully", HttpStatus.OK);
   }
}
