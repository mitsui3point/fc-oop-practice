package org.example.password;

public class CorrectPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "aabbccdd";
    }
}
