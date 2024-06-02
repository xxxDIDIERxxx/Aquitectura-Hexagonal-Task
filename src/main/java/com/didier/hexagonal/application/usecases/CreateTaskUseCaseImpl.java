package com.didier.hexagonal.application.usecases;

import com.didier.hexagonal.domain.models.Task;
import com.didier.hexagonal.domain.ports.in.CreateTaskUseCase;
import com.didier.hexagonal.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

 @AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
