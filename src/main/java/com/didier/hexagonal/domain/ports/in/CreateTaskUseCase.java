package com.didier.hexagonal.domain.ports.in;

import com.didier.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);

}
