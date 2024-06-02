package com.didier.hexagonal.application.usecases;

import com.didier.hexagonal.domain.models.Task;
import com.didier.hexagonal.domain.ports.in.UpdateTaskUseCase;
import com.didier.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
