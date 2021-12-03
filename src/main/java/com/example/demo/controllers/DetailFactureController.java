package com.example.demo.controllers;

import com.example.demo.interfaces.IDetailFacture;
import com.example.demo.models.DetailFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detail")
@CrossOrigin(origins = "*")
public class DetailFactureController {
    @Autowired
    private IDetailFacture detail;

    @PostMapping(path = "/add")
    public String add(@RequestBody DetailFacture d){
        return  detail.add(d);
    }

    @PostMapping(path = "/update")
    public String update(@RequestBody DetailFacture d){
        return  "Le détail " + detail.update(d) + " a bien été modifiée";
    }

    @PostMapping("/get")
    public  String get(@RequestBody DetailFacture d){
        return detail.add(d);
    }

    @PostMapping("/list")
    public List<DetailFacture> gets(){
        return detail.get();
    }

    @PostMapping("/find")
    public DetailFacture  find(@RequestBody DetailFacture d){
        return detail.find(d);
    }

    @PostMapping("/delete")
    public  String delete(@RequestBody DetailFacture d){
        return "La facture " + detail.delete(d.getId()) + " a bien été Supprimé";
    }
}
