package restwebapp.restdatabase1.repository;

import restwebapp.restdatabase1.domain.Person;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

//Page<Person> findAll(Pageable pageable);
	
	List<Person> findByLastName(String lastName);
	List<Person> findByfirstName(String firstName);
	
	
	//@Query("from person where firstName:firstName AND lastName:lastName")
	//List<Person> findNames(String firstName, String lastName);

	 //@Query("SELECT COUNT(u) FROM Person WHERE Person.firstName=?1")
	   // Long aMethodNameOrSomething(String firstName);
	 
	 List<Person>findByfirstName(String firstName,Pageable pageRequest);



}
