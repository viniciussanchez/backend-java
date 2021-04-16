package br.com.sanchez.userapi.controller;

import br.com.sanchez.userapi.dto.UserDTO;
import br.com.sanchez.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/cpf/{cpf}")
    UserDTO getUser(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @PostMapping("/users")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/users/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/users/search")
    public List<UserDTO> queryByNome(@RequestParam(name = "nome", required = true) String nome) {
        return userService.queryByNome(nome);
    }

}