package com.manokorea.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component // 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 Annotation
@ConfigurationProperties("jwt") // 자바 클래스에 프로퍼티 값을 가져와서 사용하는 애너테이션
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
