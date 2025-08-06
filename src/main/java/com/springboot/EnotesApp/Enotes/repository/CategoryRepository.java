package com.springboot.EnotesApp.Enotes.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springboot.EnotesApp.Enotes.dto.CategoryResponse;
import com.springboot.EnotesApp.Enotes.entity.Category;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();

}
