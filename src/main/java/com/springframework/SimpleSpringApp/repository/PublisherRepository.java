package com.springframework.SimpleSpringApp.repository;

import com.springframework.SimpleSpringApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
