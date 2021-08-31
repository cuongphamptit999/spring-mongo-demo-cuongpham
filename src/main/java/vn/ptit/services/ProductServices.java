package vn.ptit.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import vn.ptit.documents.Product;
import vn.ptit.repositories.ProductRepository;
import vn.ptit.ultils.FilterMap;

@Service
public class ProductServices {
	@Autowired ProductRepository productRepository;
	@Autowired MongoTemplate mongoTemplate;
	
	public List<Product> findSortProductLowToHigh(){
		List<Product> list = productRepository.findAll();
		Collections.sort(list, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				
				return Double.compare(o1.getPrice(), o2.getPrice());
			}
		});
		
		return list;
		
	}
	
	public List<Product> findSortProductHighToLow(){
		List<Product> list = productRepository.findAll();
		Collections.sort(list, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				
				return Double.compare(o2.getPrice(), o1.getPrice());
			}
		});
		
		return list;
		
	}
	
	

	
	
	

}
