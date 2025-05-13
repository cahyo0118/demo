package com.example.snap.service;

import com.example.snap.exception.AuthException;
import com.example.snap.model.Merchant;
import com.example.snap.model.User;
import com.example.snap.repository.MerchantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class AuthServiceTest {

    @Mock
    private MerchantRepository merchantRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    void createB2bToken_merchantFound() {
        String merchantId = "PARTNER01";
        when(merchantRepository.findByMerchantId(merchantId)).thenReturn(Optional.of(new Merchant(
                "PARTNER01",
                "PARTNER 01"
        )));

        assertNotNull(this.authService.createB2bToken(merchantId));
    }

    @Test
    void createB2bToken_merchantNotFound() {
        String merchantId = "PARTNER01";
        when(merchantRepository.findByMerchantId(any())).thenReturn(Optional.empty());

        AuthException badRequestException = assertThrows(AuthException.class, () -> this.authService.createB2bToken(merchantId));

        assertEquals("Partner Not Found", badRequestException.getMessage());
    }
}