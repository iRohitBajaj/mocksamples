package com.rohit;

import com.rohit.config.JpaLocalConfig;
import com.rohit.model.Person;
import com.rohit.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes={JpaLocalConfig.class})
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigurationPackage
public class IntegrationTest {

@Autowired
    PersonRepository personRepository;

    @Test
    public void shouldSavePerson(){
        Person person = new Person("first", 5D);
        personRepository.save(person);
        Optional<Person> person1 = personRepository.findById("first");
        person1.ifPresent((p) -> System.out.println(p.getHeight()));
    }

}
