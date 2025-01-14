package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="medallas")
public class Medalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="lider")
    private String lider;

    @ManyToMany(mappedBy = "medallas")
    private List<Entrenador> entrenador;

    public Medalla() {
    }

    public Medalla(String nombre, String lider) {
        this.nombre = nombre;
        this.lider = lider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", lider='" + lider + '\'' +
                '}';
    }
}
