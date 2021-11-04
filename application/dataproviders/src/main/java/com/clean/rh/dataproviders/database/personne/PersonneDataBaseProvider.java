package com.clean.rh.dataproviders.database.personne;

import com.clean.rh.dataproviders.database.personne.mapper.PersonneRowMapper;
import com.clean.rh.entity.Personne;
import com.clean.rh.usercase.personne.PersonneRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class PersonneDataBaseProvider implements PersonneRepository {

    private JdbcTemplate jdbcTemplate;

    public PersonneDataBaseProvider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Personne> creer(Personne personne) {

        jdbcTemplate.update("INSERT INTO clean_architecture.personne (id, nom, prenom, age, email) " +
                        " VALUES (personne_id_seq.nextval, ?,?,?,?)"
                , personne.getNom(), personne.getPrenom(), personne.getAge(), personne.getEmail());

        return Optional.of(personne);


    }

    @Override
    public Optional<Personne> recupererPersonneByEmail(String email) {

        String sql = "SELECT id, nom, prenom, age, email FROM clean_architecture.PERSONNE WHERE email = ?";

        try {
            Personne personne = jdbcTemplate.queryForObject(sql, new PersonneRowMapper(), email);
            return Optional.of(personne);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
