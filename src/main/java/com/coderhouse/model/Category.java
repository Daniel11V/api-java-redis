package com.coderhouse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    public Category() {}

    public Category(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {return String.format(
            "Categoria[nombre='%s']", nombre);
    }
}
