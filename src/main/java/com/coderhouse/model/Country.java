package com.coderhouse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    public Country() {}

    public Country(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {return String.format(
            "Pais[nombre='%s']", nombre);
    }

}
