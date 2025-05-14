package com.exemple.service;

import com.exemple.model.Article;

import java.util.HashMap;
import java.util.Map;

public class ArticleService extends Service<Article> {

    public ArticleService() {
        super(Article.class);
    }

    public void print(Article entity) {
        Map<String,String> attributes = new HashMap<String,String>();
        if (entity != null) {
            attributes.put("ID", entity.getId().toString());
            attributes.put("title", entity.getTitle());
            attributes.put("content", entity.getContent());
        }
        print(attributes);
    }

}
