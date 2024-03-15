package com.manokorea.springbootdeveloper.service;

import com.manokorea.springbootdeveloper.domain.RefreshToken;
import com.manokorea.springbootdeveloper.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 전달받은 리프레시 토큰으로 리프레시 토큰 객체를 검색해서 전달하는 findByRefreshToken() 메소드 구현
 */
@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
