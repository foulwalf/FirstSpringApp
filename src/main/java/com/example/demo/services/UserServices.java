package com.example.demo.services;

import com.example.demo.interfaces.IUser;
import com.example.demo.models.Article;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServices implements IUser {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String addUser(User user) {
        return null;
    }

    @Override
    public User connectUser(User u) {
        String sql = "select * from tb_user where username = :username and mdp = :mdp";
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("username",u.getUsername());
        parameters.put("mdp",u.getMdp());
        User currentUser;
        try {
            currentUser = namedParameterJdbcTemplate.queryForObject(sql,parameters,new UserRowMapper());
        }catch (Exception e){
            return currentUser = new User();
        }
        return currentUser;
    }
}

class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("username"), resultSet.getString("mdp"), resultSet.getString("type"), resultSet.getInt("etat") );
        return u;
    }
}
