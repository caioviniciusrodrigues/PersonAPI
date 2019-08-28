package br.com.refeitorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.refeitorio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
