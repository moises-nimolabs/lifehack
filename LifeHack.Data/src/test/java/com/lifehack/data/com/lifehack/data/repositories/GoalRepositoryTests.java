package com.lifehack.data.com.lifehack.data.repositories;

import com.lifehack.data.entities.Goal;
import com.lifehack.data.repositories.GoalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GoalRepositoryTests {

    GoalRepository goalRepository = mock(GoalRepository.class);

    @Test
    public void getGoal() {
        Goal item = new Goal();
        item.id = 1L;
        Optional<Goal> response = Optional.of(item);
        when(goalRepository.findBySequence(1)).thenReturn(response);
        Goal result = goalRepository.findBySequence(1).get();
        assertThat(result.id == 1L);
    }
}
