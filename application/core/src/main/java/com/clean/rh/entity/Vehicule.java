package com.clean.rh.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Vehicule {
    private  String matricule;
    private String modele;
    private String marque;
}
