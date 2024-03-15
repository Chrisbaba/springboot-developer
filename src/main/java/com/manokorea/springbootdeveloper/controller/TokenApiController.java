package com.manokorea.springbootdeveloper.controller;

import com.manokorea.springbootdeveloper.dto.CreateAccessTokenRequest;
import com.manokorea.springbootdeveloper.dto.CreateAccessTokenResponse;
import com.manokorea.springbootdeveloper.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 실제로 요청을 받고 처리할 컨트롤러 생성.
 * /api/token POST 요청이 오면 토큰 서비스에서 리프레시 토큰을 기반으로 새로운
 * 액세스 토큰을 만들어 준다.
 */
@RequiredArgsConstructor
@RestController // Spring에서 Controller 중 View로 응답하지 않는, Controller를 의미
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken
            (@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
