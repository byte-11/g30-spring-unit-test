package uz.byte11.springbootunittest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.byte11.springbootunittest.dto.request.UserRegistrationDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    public User(UserRegistrationDto registrationDto) {
        this.username = registrationDto.username();
        this.email = registrationDto.email();
        this.password = registrationDto.password();
    }
}
