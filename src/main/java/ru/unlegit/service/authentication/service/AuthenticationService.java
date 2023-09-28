package ru.unlegit.service.authentication.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.unlegit.service.authentication.dto.RegistrationCandidate;
import ru.unlegit.service.authentication.dto.VerificationData;
import ru.unlegit.service.authentication.model.Account;

import java.util.Date;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class AuthenticationService {

    AccountService accountService;
    CryptoService cryptoService;

    public boolean exists(String name) {
        return accountService.exists(name);
    }

    public void signup(RegistrationCandidate candidate) {
        var account = new Account();

        account.setName(candidate.name());
        account.setPasswordHash(cryptoService.hash(candidate.password()));
        account.setRegistrationAddress(candidate.address());
        account.setRegistrationTime(new Date());

        accountService.save(account);
    }

    public boolean verify(VerificationData data) {
        var account = accountService.getAccount(data.name());

        return cryptoService.verify(data.password(), account.getPasswordHash());
    }
}