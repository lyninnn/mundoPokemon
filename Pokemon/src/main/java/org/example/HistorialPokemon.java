package org.example;

import javax.persistence.*;

@Entity
@Table(name="historialPokemon")
public class HistorialPokemon {

    @EmbeddedId //PK embebida (dentro de otra)
    private HistorialPokemonPK id;

    @ManyToOne
    @MapsId("idEntrenador")  //Forma parte de la PK compartida y lo establecemos en la clase HistorialPokemonPK
    @JoinColumn(name="idEntrenador", insertable = false, updatable = false)
    private Entrenador entrenador;

    @ManyToOne
    @MapsId("idPokemon")  //Forma parte de la PK compartida y lo establecemos en la clase HistorialPokemonPK
    @JoinColumn(name="idPokemon", insertable = false, updatable = false)
    private Pokemon pokemon;


    @Column(name="evento")
    private String evento;

    public HistorialPokemon() {
    }

    public HistorialPokemon(Entrenador entrenador, Pokemon pokemon, String evento) {
        this.entrenador = entrenador;
        this.pokemon = pokemon;
        this.evento = evento;
    }


    public HistorialPokemonPK getId() {
        return id;
    }

    public void setId(HistorialPokemonPK id) {
        this.id = id;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "HistorialPokemon{" +
                "id=" + id +
                ", evento='" + evento + '\'' +
                '}';
    }
}
