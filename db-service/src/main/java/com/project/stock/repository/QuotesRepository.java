package com.project.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stock.model.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String username);

}
