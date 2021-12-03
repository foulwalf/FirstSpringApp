package com.example.demo.models;

public class User {
    private Integer id;
    private String nom;
    private String username;
    private String mdp;
    private String type;
    private Integer etat;

    public User() {
    }

    public User(Integer id, String nom, String username, String mdp, String type, Integer etat) {
        this.id = id;
        this.nom = nom;
        this.username = username;
        this.mdp = mdp;
        this.type = type;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }
}
