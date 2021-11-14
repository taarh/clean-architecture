package com.tracker.dataproviders.database.personne.mapper;

import com.tracker.entity.Personne;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneRowMapper implements RowMapper<Personne> {

    @Override
    public Personne mapRow(ResultSet resultSet, int i) throws SQLException {
        return Personne.builder().nom(resultSet.getString("NOM")).prenom(resultSet.getString("PRENOM"))
                .age(resultSet.getInt("AGE")).email(resultSet.getString("EMAIL")).id(resultSet.getString("ID")).build();

    }
}
