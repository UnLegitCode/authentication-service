package ru.unlegit.service.authentication.repository;

import org.springframework.data.repository.CrudRepository;
import ru.unlegit.service.authentication.model.Account;

public interface AccountRepository extends CrudRepository<Account, String> {}