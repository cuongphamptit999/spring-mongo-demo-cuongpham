package vn.ptit.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import vn.ptit.documents.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	List<Product> findByCategoryId(String id);
	List<Product> findBySlug(String slug);
	List<Product> findByBrand(String brand);
	List<Product> findByMaterial(String material);

}
