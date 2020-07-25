package com.springframework.SimpleSpringApp.repository;

import com.springframework.SimpleSpringApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
