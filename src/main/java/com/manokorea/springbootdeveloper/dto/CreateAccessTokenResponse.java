package com.manokorea.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 토큰 생성 응답
 */
@AllArgsConstructor // Lombok Annotation - 모든 필드 값을 파라미터로 받는 생성자를 추가
@Getter
public class CreateAccessTokenResponse {
    private String accessToken;
}
