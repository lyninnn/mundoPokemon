package org.example;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class HistorialPokemonPK implements Serializable {

    @Column(name="idEntrenador")
    private int idEntrenador;

    @Column(name="idPokemon")
    private int idPokemon;

    @Column(name="fecha")
    private LocalDate fecha;


    public HistorialPokemonPK() {
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
