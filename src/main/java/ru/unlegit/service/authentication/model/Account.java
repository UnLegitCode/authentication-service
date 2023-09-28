package ru.unlegit.service.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Account {

    @Id
    String name;
    String passwordHash;
    Date registrationTime;
    String registrationAddress;
}