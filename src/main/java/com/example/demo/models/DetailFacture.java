package com.example.demo.models;

public class DetailFacture {
    private Integer id;
    private Integer id_facture;
    private Integer id_article;
    private Integer pu;
    private Integer qte;

    public DetailFacture(Integer id, Integer id_facture, Integer id_article, Integer pu, Integer qte) {
        this.id = id;
        this.id_facture = id_facture;
        this.id_article = id_article;
        this.pu = pu;
        this.qte = qte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_facture() {
        return id_facture;
    }

    public void setId_facture(Integer id_facture) {
        this.id_facture = id_facture;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Integer getPu() {
        return pu;
    }

    public void setPu(Integer pu) {
        this.pu = pu;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
