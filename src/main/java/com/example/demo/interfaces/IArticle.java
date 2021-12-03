package com.example.demo.interfaces;

import com.example.demo.models.Article;

import java.util.List;

public interface IArticle {
    String add(Article a);
    Integer update(Article f);
    Integer delete(Integer id);
    List<Article> get();
    Article find(Integer id);
}
