package com.dcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.entity.Products;
import com.dcl.repo.ProductRepository;
import com.dcl.request.ProductRequest;
import com.dcl.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {
    @Autowired   
	ProductRepository prepo;
	

	@Override
	public Products saveProduct(ProductRequest request) {
		// TODO Auto-generated method stub
		Products p = new Products();

		p.setPName(request.getName());
		p.setPPrice(request.getPrice());
		return prepo.save(p);
	}

	@Override
	public Products getProduct(Integer id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).orElse(null);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public Products updateProduct(Integer productId, ProductRequest update) {
		// TODO Auto-generated method stub
	  Products p = prepo.findById(productId).orElse(null);
	  if(p!=null) {
		  p.setPId(productId);
		  p.setPName(update.getName());
		  p.setPPrice(update.getPrice());
		  return prepo.save(p);
	  }
	  else {
		  return p;
	  }
	}

	@Override
	public void deleteProducts(Integer id) {
		// TODO Auto-generated method stub
		prepo.deleteById(id);
	}

}
