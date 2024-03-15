package com.manokorea.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok Annotation - 기본 생성자를 자동으로 추가한다.
@Getter // Lombok Annotation - Class 내 모든 필드의 Getter method를 자동 생성한다.
@Entity // JPA Annotation - 실제 DB의 테이블과 매칭될 Class임을 명시한다.
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    public RefreshToken(Long userId, String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }

    public RefreshToken update(String newRefreshToken) {
        refreshToken = newRefreshToken;
        return this;
    }
}
