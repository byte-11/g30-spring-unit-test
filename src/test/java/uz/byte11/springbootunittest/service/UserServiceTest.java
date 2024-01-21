package uz.byte11.springbootunittest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uz.byte11.springbootunittest.domain.User;
import uz.byte11.springbootunittest.dto.UserDto;
import uz.byte11.springbootunittest.dto.request.UserRegistrationDto;
import uz.byte11.springbootunittest.repo.UserRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UserServiceTest {

//    @Autowired
    private UserService userService;

//    @Autowired
    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
//        userRepo = Mockito.mock(UserRepo.class);
        userService = new UserService(userRepo);
    }

    @Test
    void testRegister_thenThrowIllegalState() {
        UserRegistrationDto registrationDto = new UserRegistrationDto("alex", "alex@gmail.com", "1234");

        when(userRepo.findByEmail(anyString())).thenReturn(Optional.of(new User()));

        var exception = assertThrows(IllegalStateException.class, () -> userService.registerUser(registrationDto));
        assertEquals("User already registered", exception.getMessage());

    }

    @Test
    void testRegister_thenSaveUser() {
        UserRegistrationDto registrationDto = new UserRegistrationDto("alex", "alex@gmail.com", "1234");
        User user = new User(registrationDto);

        when(userRepo.findByEmail(anyString())).thenReturn(Optional.empty());
        user.setId(1L);
        when(userRepo.save(any(User.class))).thenReturn(user);
        UserDto userDto = new UserDto(user);
        UserDto actual = userService.registerUser(registrationDto);
        assertEquals(userDto.getId(), actual.getId());
        assertEquals(userDto.getEmail(), actual.getEmail());
        assertEquals(userDto.getUsername(), actual.getUsername());

        verify(userRepo).findByEmail(anyString());
        verify(userRepo).save(any(User.class));
    }
}