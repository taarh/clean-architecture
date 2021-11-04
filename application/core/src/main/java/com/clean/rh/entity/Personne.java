package com.clean.rh.entity;

import lombok.*;


@Builder
@Getter
@EqualsAndHashCode
public class Personne {
    private  String id;
    private String nom;
    private String prenom;
    private int age;
    private String email;
}
