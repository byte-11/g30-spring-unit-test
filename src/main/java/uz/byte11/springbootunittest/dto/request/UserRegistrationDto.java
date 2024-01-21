package uz.byte11.springbootunittest.dto.request;

public record UserRegistrationDto(
        String username,
        String email,
        String password
) {
}
