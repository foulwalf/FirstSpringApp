package com.example.demo.controllers;

import com.example.demo.interfaces.IArticle;
import com.example.demo.models.Article;
import com.example.demo.models.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
@CrossOrigin(origins = "*")
public class ArticleController {
    @Autowired
    private IArticle article;

    @PostMapping(path = "/add")
    public String add(@RequestBody Article a){
        return  article.add(a);
    }

    @PostMapping(path = "/update")
    public String update(@RequestBody Article a){
        return  "L'article " + article.update(a) + " a bien été modifiée";
    }


    @PostMapping("/list")
    public List<Article> gets(){
        return article.get();
    }

    @PostMapping("/find")
    public Article  find(@RequestBody Integer id){
        return article.find(id);
    }

    @PostMapping("/delete")
    public  String delete(@RequestBody Article a){
        return "La facture " + article.delete(a.getId()) + " a bien été Supprimé";
    }
}
