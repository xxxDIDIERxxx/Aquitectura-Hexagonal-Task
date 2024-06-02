package com.didier.hexagonal.domain.ports.in;

import com.didier.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);

    List<Task> getAllTask();

}
