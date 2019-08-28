package br.com.refeitorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.refeitorio.exception.ResourceNotFoundException;
import br.com.refeitorio.model.Person;
import br.com.refeitorio.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;

	public List<Person> findAll() {
		
		return repo.findAll();
		
	}

	public Person save(Person person) {
		
		return repo.save(person);
		
	}

	public Person findById(long id) {

		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
	}

	public void deleteById(long id) {

		Person person = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repo.delete(person);
		
	}

	public Person update(Person p) {

		Person person = repo.findById(p.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		person.setFirstName(p.getFirstName());
		person.setLastName(p.getLastName());
		person.setAddress(p.getAddress());
		person.setGender(p.getGender());

		return repo.save(person);

	}

}
