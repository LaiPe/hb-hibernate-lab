package com.exemple.service;

import com.exemple.model.Article;
import com.exemple.model.User;

public class ArticleService extends Service<Article> {

    public ArticleService() {
        super(Article.class);
    }

    public void print(Article entity) {
        String msg = "";
        if (entity != null) {
            msg = entity.getId() + " " + entity.getTitle();
        }
        print(msg);
    }

}
