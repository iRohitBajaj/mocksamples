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

public class Service2Test {

    private Person person = new Person("fakeguy2", 7D);

    @Test
    public void shouldSavePerson(){

        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        PersonService ystemUnderTest = new PersonService(personRepository);

        ystemUnderTest.addPerson(person);

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        Mockito.verify(personRepository).save(captor.capture());
        Assertions.assertThat(captor.getValue().getHeight()).isEqualTo(9D);
    }

    @Test
    public void shouldDeletePerson(){

        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        PersonService sytemUnderTest = new PersonService(personRepository);
        sytemUnderTest.deletePerson(person.getName());

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        Mockito.verify(personRepository).delete(captor.capture());
        Assertions.assertThat(captor.getValue()).isEqualTo(person);

    }

}
