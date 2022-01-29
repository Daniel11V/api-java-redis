package com.coderhouse.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country pais;

    public City() {}

    public City(String nombre, Country pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public String toString() {return String.format(
            "Ciudad[nombre='%s', pais='%s']", nombre, pais.getNombre());
    }

}
