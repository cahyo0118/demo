package com.example.snap.service;

import com.example.snap.constant.ReturnCodeEnum;
import com.example.snap.exception.AuthException;
import com.example.snap.model.Merchant;
import com.example.snap.model.User;
import com.example.snap.repository.MerchantRepository;
import com.example.snap.repository.UserRepository;
import com.example.snap.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MerchantRepository merchantRepository;

    public String createB2bToken(String merchantId) {
        Merchant merchant = this.merchantRepository.findByMerchantId(merchantId).orElseThrow(() -> new AuthException(ReturnCodeEnum.PARTNER_NOT_FOUND_73));
        return JwtUtil.generateToken(merchant.getMerchantId());
    }

}
