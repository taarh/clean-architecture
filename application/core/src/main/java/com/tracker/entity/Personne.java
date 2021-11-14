package com.tracker.entity;

import lombok.*;


@Builder
@Getter
@EqualsAndHashCode
public class Personne {
    private final String id;
    private final String nom;
    private final String prenom;
    private final int age;
    private final String email;
}
