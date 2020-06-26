package com.lifehack.data.com.lifehack.data.repositories;

import com.lifehack.data.entities.Person;
import com.lifehack.data.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonlRepositoryTests {
    PersonRepository goalRepository = mock(PersonRepository.class);

    @Test
    public void getPerson() {
        Person item = new Person();
        item.id = 1L;
        item.name = "Paul";
        Optional<Person> response = Optional.of(item);
        when(goalRepository.findByName("Paul")).thenReturn(response);
        Person result = goalRepository.findByName("Paul").get();
        assertThat(result.id == 1L);
    }
}
