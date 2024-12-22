package br.com.richard.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.richard.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
