package com.coderhouse.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "restaurante_id")
    private List<Category> categorias = new ArrayList<>();
    private String descripcion;
    private String horaApertura;
    private String horaCierre;
    private String latitud;
    private String longitud;
    private String nombre;
    private String telefono;
    private Date fechaCreacion = Calendar.getInstance().getTime();
    @ManyToOne(cascade = CascadeType.ALL)
    private City ciudad;
    private String phone;

    @Override
    public String toString() {return String.format(
            "Restaurante[id=%d, nombre='%s']", id, nombre);
    }

    public void setCategorias(List<Category> categorias) {
        this.categorias = categorias;
    }

    public List<Category> getCategorias() {
        return categorias;
    }
}
