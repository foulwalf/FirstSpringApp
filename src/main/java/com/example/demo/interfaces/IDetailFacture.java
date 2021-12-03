package com.example.demo.interfaces;

import com.example.demo.models.DetailFacture;

import java.util.List;

public interface IDetailFacture {
    String add(DetailFacture d);
    Integer update(DetailFacture d);
    Integer delete(Integer id);
    List<DetailFacture> get();
    DetailFacture find(DetailFacture d);
}
