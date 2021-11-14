package com.tracker.dataproviders.middleware.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PositionGpsK {
    private String matricule;
    private String latitude;
    private String longitude;
    private LocalDateTime dateEnregistrementPosition;
}
