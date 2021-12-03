package com.example.demo.controllers;

import com.example.demo.interfaces.IFacture;
import com.example.demo.models.DetailFacture;
import com.example.demo.models.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("facture")
@CrossOrigin(origins = "*")
public class FactureController {

    @Autowired
    private IFacture facture;

    @PostMapping("/add")
    public  String add(@RequestBody Facture f){
        return facture.add(f);
    }

    @PostMapping("/update")
    public  String update(@RequestBody Facture f){
        return "La facture " + facture.update(f) + " a bien été modifié";
    }

    @PostMapping("/list")
    public List<Facture> gets(){
        return facture.get();
    }

    @PostMapping("/find")
    public Facture  find(@RequestBody Integer id){
        return facture.find(id);
    }

    @PostMapping("/delete")
    public  String delete(@RequestBody Facture f){
        return "La facture " + facture.delete(f.getId()) + " a bien été Supprimé";
    }
    @PostMapping("/getFactureDetails")
    public List<DetailFacture> getFactureDetails(@RequestBody Integer id){
        return  facture.getFactureDetails(id);
    }
}
