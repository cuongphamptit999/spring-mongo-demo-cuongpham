package vn.ptit.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.documents.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
	List<Category> findBySlug(String slug);
}
