package com.example.demo.interfaces;

import com.example.demo.models.DetailFacture;
import com.example.demo.models.Facture;

import java.util.List;
import java.util.Map;

public interface IFacture {
    String add(Facture f);
    Integer update(Facture f);
    Integer delete(Integer id);
    List<Facture> get();
    Facture find(Integer id);
    List<DetailFacture> getFactureDetails(Integer id);
}
