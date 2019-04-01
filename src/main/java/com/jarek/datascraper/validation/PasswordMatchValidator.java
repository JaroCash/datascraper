package com.jarek.datascraper.validation;

import com.jarek.datascraper.entity.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator <PasswordMatch, Object> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        UserDTO userDTO = (UserDTO) o;

        if(userDTO.getPassword()!=null) {
            return userDTO.getPassword()
                          .equals(userDTO.getMatchingPassword());
        }

        return false;
    }
}
