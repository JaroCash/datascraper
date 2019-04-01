package com.jarek.datascraper.validation;



import com.jarek.datascraper.entity.UserDTO;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class PasswordMatchValidatorTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void shouldNotValid() {
        UserDTO userDTO = new UserDTO();

        userDTO.setLogin("login");
        userDTO.setEmail("email");
        userDTO.setPassword("password");
        userDTO.setMatchingPassword("haslo");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        Set<String> violationsList = violations.stream().map(m ->m.getMessageTemplate()).collect(Collectors.toSet());
        assertTrue(violationsList.contains("Passwords don't match"));

    }
}
