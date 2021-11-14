package com.clean.rh.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class PositionGps {
    private String id;
    private String matricule;
    private String latitude;
    private String longitude;
    private LocalDateTime dateEnregistrementPosition;
}
