package com.tracker.dataproviders.database.positionGps;

import com.tracker.dataproviders.database.positionGps.mapper.PositionGpsRowMapper;
import com.tracker.entity.PositionGps;
import com.tracker.usercase.coordonneesgps.PositionGpsRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PositionGpsDataBaseProvider implements PositionGpsRepository {

    private final JdbcTemplate jdbcTemplate;

    public PositionGpsDataBaseProvider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Optional<PositionGps> creerPositionGps(PositionGps positionGPS) {
        jdbcTemplate.update("INSERT INTO clean_architecture.positionGps (id,matricule, latitude, longitude,date_enreg) " +
                        " VALUES (positiongps_id_seq.nextval, ?,?,?,?)"
                , positionGPS.getMatricule(),positionGPS.getLatitude(), positionGPS.getLongitude(), LocalDateTime.now());

        return Optional.of(positionGPS);
    }

    @Override
    public List<PositionGps> recupererPositionGpsParMatricule(String matricule) {
        String sql = "SELECT id, matricule, latitude, longitude,date_enreg FROM clean_architecture.positiongps WHERE matricule = ?";
        try {
            List<PositionGps> positionGPSs = jdbcTemplate.query(sql,new Object[]{matricule},new PositionGpsRowMapper());
            return positionGPSs;
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }
}
