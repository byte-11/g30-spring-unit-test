package uz.byte11.springbootunittest.dto;

import lombok.Getter;
import lombok.Setter;
import uz.byte11.springbootunittest.domain.User;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String username;

    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
