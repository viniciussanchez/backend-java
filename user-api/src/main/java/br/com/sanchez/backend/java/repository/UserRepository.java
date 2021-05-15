package br.com.sanchez.backend.java.repository;

import br.com.sanchez.backend.java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpf(String cpf);
    List<User> queryByNomeLike(String nome);

}