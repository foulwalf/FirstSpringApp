package com.example.demo.models;

public class Article {
    private Integer id;
    private String designation;
    private String prix;
    private String photo;

    public Article(Integer id, String designation, String prix, String photo) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.photo = photo;
    }

    public Article() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
