package botero.pelaez.santiago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import botero.pelaez.santiago.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}