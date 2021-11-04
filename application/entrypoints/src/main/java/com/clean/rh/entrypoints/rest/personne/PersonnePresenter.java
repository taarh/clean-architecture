package com.clean.rh.entrypoints.rest.personne;

import com.clean.rh.entity.Personne;
import lombok.Data;

@Data
public class PersonnePresenter {

    private String nom;
    private String prenom;
    private int age;
    private String email;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static PersonnePresenter convertirEnPersonnePresenter(Personne personne) {
        PersonnePresenter personnePresenter = new PersonnePresenter();
        personnePresenter.age = personne.getAge();
        personnePresenter.email = personne.getEmail();
        personnePresenter.prenom = personne.getPrenom();
        personnePresenter.nom= personne.getNom();


        return personnePresenter;


    }

    public static Personne convertirEnPersonne(PersonnePresenter personnePresenter) {


        return Personne.builder().age(personnePresenter.getAge()).email(personnePresenter.getEmail()).prenom(personnePresenter.getPrenom()).nom(personnePresenter.getNom()).build();


    }


}
