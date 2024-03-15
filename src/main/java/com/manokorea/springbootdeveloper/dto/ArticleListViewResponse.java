package com.manokorea.springbootdeveloper.dto;

import com.manokorea.springbootdeveloper.domain.Article;
import lombok.Getter;

// View에게 데이터를 전달하기 위한 객체 생성
@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        id = article.getId();
        title = article.getTitle();
        content = article.getContent();
    }
}
