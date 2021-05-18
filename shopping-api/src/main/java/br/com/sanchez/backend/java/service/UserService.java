package br.com.sanchez.backend.java.service;

import br.com.sanchez.backend.java.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    public UserDTO getUserByCpf(final String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/users/cpf/" + cpf;
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
        return response.getBody();
    }
}