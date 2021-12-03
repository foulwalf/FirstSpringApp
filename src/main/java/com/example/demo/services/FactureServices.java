package com.example.demo.services;

import com.example.demo.interfaces.IFacture;
import com.example.demo.models.DetailFacture;
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
public class FactureServices implements IFacture {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String add(Facture f) {
        int rep = jdbcTemplate.update(
                "INSERT INTO tb_facture(client, contact) VALUES (?,?)", f.getClient(), f.getContact());
        return rep + "Ajout effectué";
    }

    @Override
    public Integer update(Facture f) {
        return jdbcTemplate.update("update tb_facture set client = ?, contact = ? where id = ?", f.getClient(), f.getContact(), f.getId());
    }

    @Override
    public Integer delete(Integer id) {
        return jdbcTemplate.update("delete from tb_facture where id = ?", id);
    }

    @Override
    public List<Facture> get() {
        return jdbcTemplate.query(
                "select * from tb_facture",
                (f, rows) ->
                        new Facture(
                                f.getInt("id"),
                                f.getString("client"),
                                f.getString("contact")
                        )
        );
    }

    @Override
    public Facture find(Integer id) {
        String sql = "select * from tb_facture where id = :id";
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("id", id);
        Facture facture;
        try {
            facture = namedParameterJdbcTemplate.queryForObject(sql, parameters, new FactureRowMapper());
        } catch (Exception ex) {
            facture = null;
        }
        return facture;
    }

    @Override
    public List<DetailFacture> getFactureDetails(Integer id) {
        String sql = "select * from tb_detail_facture where id_facture = :id";
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("id", id);
        return namedParameterJdbcTemplate.query(sql, parameters, (d, rows) -> new DetailFacture(
                        d.getInt("id"),
                        d.getInt("id_facture"),
                        d.getInt("id_article"),
                        d.getInt("pu"),
                        d.getInt("qte")
                )
        );
    }
}

class FactureRowMapper implements RowMapper<Facture> {
    @Override
    public Facture mapRow(ResultSet resultSet, int i) throws SQLException {
        Facture f = new Facture();
        f.setId(resultSet.getInt("id"));
        f.setContact(resultSet.getString("contact"));
        f.setClient(resultSet.getString("client"));
        return f;
    }
}
