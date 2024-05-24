package com.example.calculatriceg1java.entities;

public class Calcul extends BaseEntity{
    Integer premierElement;
    Integer deuxiemeELement;
    String symbole;
    Integer resultat;

    public Integer getPremierElement() {
        return premierElement;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public Integer getDeuxiemeELement() {
        return deuxiemeELement;
    }

    public void setDeuxiemeELement(Integer deuxiemeELement) {
        this.deuxiemeELement = deuxiemeELement;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }
}
