package com.example.snap.repository;

import com.example.snap.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByMsisdn(String msisdn);
}
