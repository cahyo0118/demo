package com.example.snap.service;

import com.example.snap.model.User;
import com.example.snap.repository.UserRepository;
import com.example.snap.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String createB2bToken(String msisdn) throws BadRequestException {
        // check is user exist
        User user = this.userRepository.findByMsisdn(msisdn).orElseThrow(() -> new BadRequestException("Bad Request"));
        return JwtUtil.generateToken(user.getId());
    }

}
