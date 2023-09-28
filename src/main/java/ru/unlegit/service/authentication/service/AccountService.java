package ru.unlegit.service.authentication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unlegit.service.authentication.exception.AccountNotFoundException;
import ru.unlegit.service.authentication.model.Account;
import ru.unlegit.service.authentication.repository.AccountRepository;

@Service
@AllArgsConstructor
public final class AccountService {

    private final AccountRepository repository;

    public Account getAccount(String name) {
        return repository.findById(name).orElseThrow(AccountNotFoundException::new);
    }

    public void save(Account account) {
        repository.save(account);
    }

    public boolean exists(String name) {
        return repository.existsById(name);
    }

    public void delete(String name) {
        repository.deleteById(name);
    }
}