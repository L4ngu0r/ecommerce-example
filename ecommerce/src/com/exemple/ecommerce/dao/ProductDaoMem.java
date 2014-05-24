package com.exemple.ecommerce.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exemple.ecommerce.bean.Product;
import com.exemple.ecommerce.exceptions.UnknownProductException;

public class ProductDaoMem implements ProductInterface {

	private List<Product> products = new ArrayList<Product>();
	private Long idSequence = 1L;
	
	@Override
	public List<Product> getAllProducts() {
		return Collections.unmodifiableList(products);
	}

	@Override
	public void addProduct(Product p) throws UnknownProductException {
		p.setId(idSequence++);
		products.add(p);
	}

	@Override
	public Product findProduct(Long id) throws UnknownProductException {
		int index = getProductByIndex(id);
		if(index > -1){
			Product p = products.get(index);
			return p;
		}
		throw new UnknownProductException(id);
	}

	@Override
	public void removeProduct(Long id) throws UnknownProductException {
		int index = getProductByIndex(id);
		if(index > -1){
			products.remove(index);
		}else{
			throw new UnknownProductException(id);
		}
	}

	@Override
	public void removeProduct(Product p) throws UnknownProductException {
		removeProduct(p.getId());
	}

	@Override
	public void updateProduct(Product p) throws UnknownProductException {
		int index = getProductByIndex(p.getId());
		if(index > -1){
			products.set(index, p);
		}else{
			throw new UnknownProductException(p.getId());
		}
	}
	
	private int getProductByIndex(Long id){
		for(int i = 0; i < products.size(); i++){
			Product p = products.get(i);
			if(p.getId().equals(id)){
				return i;
			}
		}
		return -1;
	}

}
