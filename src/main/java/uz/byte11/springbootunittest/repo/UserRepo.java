package uz.byte11.springbootunittest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.byte11.springbootunittest.domain.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
