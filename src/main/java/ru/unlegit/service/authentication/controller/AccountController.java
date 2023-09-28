package ru.unlegit.service.authentication.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.service.authentication.model.Account;
import ru.unlegit.service.authentication.service.AccountService;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public final class AccountController {

    private final AccountService service;

    @GetMapping("/{name}")
    public Account getAccount(@PathVariable String name) {
        return service.getAccount(name);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name) {
        service.delete(name);
    }
}