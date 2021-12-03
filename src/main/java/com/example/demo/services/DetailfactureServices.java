package com.example.demo.services;

import com.example.demo.interfaces.IDetailFacture;
import com.example.demo.models.DetailFacture;
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
public class DetailfactureServices implements IDetailFacture {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String add(DetailFacture d) {
        int rep = jdbcTemplate.update("INSERT INTO tb_detail_facture(id_facture, id_article, pu, qte) VALUES (?,?,?,?)", d.getId_facture(), d.getId_article(), d.getPu(), d.getQte());
        return rep + "Détail ajouté";
    }

    @Override
    public Integer update(DetailFacture d) {
        DetailFacture DetailFactureAModifier = find(d);
        if (DetailFactureAModifier == null) {
            return 0;
        } else {
            return jdbcTemplate.update("INSERT INTO tb_detail_facture(id_facture, id_article, pu, qte) VALUES ()", d.getId_facture(), d.getId_article(), d.getPu(), d.getQte());
        }
    }

    @Override
    public Integer delete(Integer id) {
        return jdbcTemplate.update(
                "DELETE FROM tb_detail_facture WHERE id = ?",
                id);
    }

    @Override
    public List<DetailFacture> get() {
        return jdbcTemplate.query(
                "select * from tb_detail_facture",
                (d, rows) ->
                        new DetailFacture(
                                d.getInt("id"),
                                d.getInt("id_facture"),
                                d.getInt("id_article"),
                                d.getInt("pu"),
                                d.getInt("qte")
                        )
        );
    }

    @Override
    public DetailFacture find(DetailFacture d) {
        String sql = "select * from tb_detail.facture where id = :id";
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("id", d.getId());
        DetailFacture detailFacture;
        try {
            detailFacture = namedParameterJdbcTemplate.queryForObject(sql, parameters, new DetailFactureRowMapper());
        } catch (Exception ex) {
            detailFacture = null;
        }
        return detailFacture;
    }
}

class DetailFactureRowMapper implements RowMapper<DetailFacture> {
    @Override
    public DetailFacture mapRow(ResultSet resultSet, int i) throws SQLException {
        return new DetailFacture(
                resultSet.getInt("id"),
                resultSet.getInt("id_facture"),
                resultSet.getInt("id_article"),
                resultSet.getInt("pu"),
                resultSet.getInt("qte")
        );
    }
}
