package uz.byte11.springbootunittest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.byte11.springbootunittest.domain.User;
import uz.byte11.springbootunittest.dto.UserDto;
import uz.byte11.springbootunittest.dto.request.UserRegistrationDto;
import uz.byte11.springbootunittest.repo.UserRepo;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public UserDto registerUser(UserRegistrationDto registrationDto) {
        Optional<User> optionalUser = userRepo.findByEmail(registrationDto.email());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("User already registered");
        }
        User user = new User(registrationDto);
        user = userRepo.save(user);

        return new UserDto(user);
    }
}
