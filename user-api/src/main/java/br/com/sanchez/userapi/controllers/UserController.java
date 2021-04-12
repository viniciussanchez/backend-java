package br.com.sanchez.userapi.controllers;

import br.com.sanchez.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void init() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Vinicius");
        userDTO.setCpf("43845970008");
        userDTO.setEndereco("Rua A");
        userDTO.setEmail("vinicius@gmail.com");
        userDTO.setTelefone("17996448184");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Ingrid");
        userDTO2.setCpf("65887448848");
        userDTO2.setEndereco("Rua B");
        userDTO2.setEmail("ingrid@gmail.com");
        userDTO2.setTelefone("17996665058");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Sandra");
        userDTO3.setCpf("65889852214");
        userDTO3.setEndereco("Rua C");
        userDTO3.setEmail("sandra@gmail.com");
        userDTO3.setTelefone("17998884652");
        userDTO3.setDataCadastro(new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/")
    public String getMensagem() {
        return "Spring boot is working!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUser(@PathVariable String cpf) {
        for (UserDTO userDTO : users) {
            if (userDTO.getCpf().equals(cpf)) {
                return userDTO;
            }
        }
        return null;
    }

    @PostMapping("/users")
    UserDTO insert(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/users/{cpf}")
    public boolean delete(@PathVariable String cpf) {
        for (UserDTO userDTO: users) {
            if (userDTO.getCpf().equals(cpf)) {
                users.remove(userDTO);
                return true;
            }
        }
        return false;
    }

}