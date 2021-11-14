package com.clean.rh.dataproviders.database.positionGps.mapper;

import com.clean.rh.entity.PositionGps;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PositionGpsRowMapper implements RowMapper<PositionGps> {

    @Override
    public PositionGps mapRow(ResultSet resultSet, int i) throws SQLException {
        return PositionGps.builder().latitude(resultSet.getString("LATITUDE")).longitude(resultSet.getString("LONGITUDE"))
                .matricule(resultSet.getString("MATRICULE")).dateEnregistrementPosition(LocalDateTime.from(resultSet.getTimestamp("DATE_ENREG").toLocalDateTime())).id(resultSet.getString("ID")).build();

    }
}
