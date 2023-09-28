package ru.unlegit.service.authentication.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class CryptoService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder(8);

    public String hash(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public boolean verify(String rawPassword, String expectedHash) {
        return encoder.matches(rawPassword, expectedHash);
    }
}