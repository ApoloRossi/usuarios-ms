package br.com.sempreva.usuarios.repository;

import br.com.sempreva.usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
