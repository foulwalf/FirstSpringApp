package com.example.demo.services;

import com.example.demo.interfaces.IArticle;
import com.example.demo.models.Article;
import com.example.demo.models.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServices implements IArticle {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public String add(Article a) {
        int rep = jdbcTemplate.update("INSERT INTO tb_article(designation,prix_recommande,photo) VALUES (?,?,?)", a.getDesignation(), a.getPrix(), a.getPhoto());
        return rep + "Article ajouté";
    }

    @Override
    public Integer update(Article a) {
        return jdbcTemplate.update("UPDATE tb_article SET designation = ? ,prix_recommande = ?, photo = ? WHERE id = ?", a.getDesignation(), a.getPrix(), a.getPhoto());
    }

    @Override
    public Integer delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM tb_article WHERE id = ?", id);
    }

    @Override
    public List<Article> get() {
        return jdbcTemplate.query(
                "select * from tb_article",
                (a, rows) ->
                        new Article(
                                a.getInt("id"),
                                a.getString("designation"),
                                a.getString("prix_recommande"),
                                a.getString("photo")
                        )
        );
    }

    @Override
    public Article find(Integer id) {
        String sql = "select * from tb_article where id = :id";
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("id", id);
        Article article;
        try {
            article = namedParameterJdbcTemplate.queryForObject(sql, parameters, new ArticleRowMapper());
        } catch (Exception ex) {
            article = null;
        }
        return article;
    }
}

class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        Article a = new Article(resultSet.getInt("id"), resultSet.getString("designation"), resultSet.getString("prix_recommande"), resultSet.getString("photo"));
        return a;
    }
}
