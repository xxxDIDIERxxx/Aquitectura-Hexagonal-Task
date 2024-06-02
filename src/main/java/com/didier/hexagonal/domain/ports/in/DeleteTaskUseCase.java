package com.didier.hexagonal.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
