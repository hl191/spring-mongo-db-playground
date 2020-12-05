package at.home;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonRepository extends MongoRepository<Person, Long> {

    @Query("{'lastName': { '$regex' : ?0 } }")
    List<Person> findByLastName(String lastName);

    @Query("{ 'username' : ?0 }")
    Person findByUsername(String username);

    List<Person> findByFirstName(String firstName);
}
