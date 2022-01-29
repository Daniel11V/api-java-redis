package com.coderhouse.repository;

import com.coderhouse.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long>  {

}

