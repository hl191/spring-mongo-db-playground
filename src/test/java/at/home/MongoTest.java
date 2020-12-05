package at.home;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoTest {

    private static final String LAST_NAME = "Holmes";
    private static final String FIRST_NAME = "Kathi";

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void init() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName(FIRST_NAME);
        person.setLastName(LAST_NAME);
        personRepository.save(person);
    }

    @Test
    void canInsertToMongoDb() {
        Person person = new Person();
        person.setId(2L);
        person.setFirstName("Reinhard");
        assertNotNull(personRepository.save(person));
    }

    @Test
    void canFindPerson() {
        assertEquals(1, personRepository.findByLastName(LAST_NAME).size());
    }

    @Test
    void canFindPersonByFirstName() {
        assertEquals(1, personRepository.findByFirstName(FIRST_NAME).size());
    }
}
