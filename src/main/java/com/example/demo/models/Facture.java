package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Facture {
    private Integer id;
    private String client;
    private String contact;
    public List<DetailFacture> details;

    public Facture(Integer id, String client, String contact) {
        this.id = id;
        this.client = client;
        this.contact = contact;
        this.details = new ArrayList<DetailFacture>();
    }

    public Facture() { }

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}
