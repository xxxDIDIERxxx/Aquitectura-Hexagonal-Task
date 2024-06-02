package com.didier.hexagonal.infrastructure.adapters;

import com.didier.hexagonal.domain.models.AdditionalTaskInfo;
import com.didier.hexagonal.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class ExternalServiceAdapter implements ExternalServicePort {
    private final RestTemplate restTemplate;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = response.getBody();
        if (todo == null) {
            return null;
        }
        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = userResponse.getBody();
        if (user == null) {
            return null;
        }
        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Setter
    @Getter
    private static class JsonPlaceholderTodo {
        private Long id;
        private Long userId;

    }

    @Setter
    @Getter
    private static class JsonPlaceholderUser {
        private Long id;
        private String name;
        private String email;
    }
}
