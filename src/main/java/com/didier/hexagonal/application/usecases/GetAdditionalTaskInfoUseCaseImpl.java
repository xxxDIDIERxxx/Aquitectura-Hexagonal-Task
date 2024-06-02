package com.didier.hexagonal.application.usecases;

import com.didier.hexagonal.domain.models.AdditionalTaskInfo;
import com.didier.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.didier.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
