package com.example.loginlogout;

import java.io.Serializable;

public class Cocktail implements Serializable {
    private String name , classs;

    public Cocktail(String name, String classs) {
        this.name = name;
        this.classs = classs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }
}
