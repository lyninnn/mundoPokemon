package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="tipo1")
    @Enumerated(EnumType.STRING)
    private TIPO1 tipo1;


    @Column(name="tipo2")
    @Enumerated(EnumType.STRING)
    private TIPO1 tipo2;

    @OneToOne(mappedBy = "pokemon")
    private Entrenador entrenador;


    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistorialPokemon> historial;


    public Pokemon() {
    }

    public Pokemon(String nombre, TIPO1 tipo1, TIPO1 tipo2) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.historial = new ArrayList<>();
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

    public TIPO1 getTipo1() {
        return tipo1;
    }

    public void setTipo1(TIPO1 tipo1) {
        this.tipo1 = tipo1;
    }

    public TIPO1 getTipo2() {
        return tipo2;
    }

    public void setTipo2(TIPO1 tipo2) {
        this.tipo2 = tipo2;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<HistorialPokemon> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<HistorialPokemon> historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo1=" + tipo1 +
                ", tipo2=" + tipo2 +
                '}';
    }
}
