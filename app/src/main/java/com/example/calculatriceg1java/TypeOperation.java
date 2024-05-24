package com.example.calculatriceg1java;

public enum TypeOperation {

    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    private String symbole;

    TypeOperation(String s) {
        this.symbole = s;
    }
}
