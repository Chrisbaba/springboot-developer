package com.manokorea.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

// /thymeleaf/example GET 요청이 오면 특정 데이터를 뷰(HTML)로 넘겨주는 모델 객체에 추가하는 컨트롤러
// Model(인터페이스) 객체는 HTML 쪽으로 넘겨주는 객체임.
@Controller // 컨트롤러라는 것을 명시적으로 표시
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) {
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("홍길동");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplePerson); // Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        // ExampleController 클래스에 붙은 애너테이션이 @Controller이므로 뷰의 이름을 반환
        // 즉, 스프링 부트는 컨트롤러의 @Controller 애너테이션을 보고 '반환하는 값의 이름을 가진 뷰의 파일'을
        // resource/templates 디렉터리에서 example.html을 찾은 다음 웹 브라우저에서 해당 파일을 보여줌.
        return "example"; // example.html 뷰 조회
    }

    @Setter
    @Getter
    private class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
