package com.didier.hexagonal.domain.ports.in;

import com.didier.hexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
