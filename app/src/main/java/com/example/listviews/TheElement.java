package com.example.listviews;

class TheElement {
    private String nombre;
    private String ci;
    TheElement(String name, String CI){
        this.nombre=name;
        this.ci = CI;
    }

    public String ToString(){
        return this.nombre + "-"+this.ci;
    }
}
