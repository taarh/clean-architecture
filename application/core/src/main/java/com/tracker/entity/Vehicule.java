package com.tracker.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Vehicule {
    private final String matricule;
    private final String modele;
    private final String marque;
}
