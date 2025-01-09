package br.com.richard.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.richard.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{}
