package com.learn.springbootgraphql.repository;


import com.learn.springbootgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
