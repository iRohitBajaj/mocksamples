package com.rohit;

import com.rohit.model.Person;
import com.rohit.repository.PersonRepository;
import com.rohit.service.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyObject;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService = new PersonService(personRepository);

    @Captor
    ArgumentCaptor<Person> captor;

    Person person = new Person("fakeguy2", 7D);

    @Before
    public void setUp(){
        //Mockito.when(personRepository.save(anyObject())).thenReturn(person);

    }

    @Test
    public void shouldSavePerson(){

        Person person1 = personService.addPerson(person);
        Mockito.verify(personRepository).save(captor.capture());
        Assertions.assertThat(captor.getValue().getHeight()).isEqualTo(9D);
    }
}
