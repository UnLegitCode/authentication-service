package ru.unlegit.service.authentication.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.service.authentication.dto.RegistrationCandidate;
import ru.unlegit.service.authentication.dto.VerificationData;
import ru.unlegit.service.authentication.service.AuthenticationService;

@RestController
@AllArgsConstructor
@RequestMapping("/authentication")
public final class AuthenticationController {

    private final AuthenticationService service;

    @GetMapping("/exists/{name}")
    public boolean exists(@PathVariable String name) {
        return service.exists(name);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody RegistrationCandidate candidate) {
        service.signup(candidate);
    }

    @GetMapping("/verify")
    public boolean verify(@RequestBody VerificationData data) {
        return service.verify(data);
    }
}