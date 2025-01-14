package org.example;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="entrenadores") //para enlazar la tabla
public class Entrenador {

    @Id //Para indicar la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Porque es autoincrement
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;


    @Column(name="ciudad")
    private String ciudad;

    @Column(name="fechaNac")
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPokemon")
    private Pokemon pokemon;

    @OneToMany(mappedBy = "entrenador", fetch = FetchType.EAGER)
    private List<Objeto> objetos;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="medallas_entrenadores",
               joinColumns = {@JoinColumn(name= "idEntrenador")},
                inverseJoinColumns = {@JoinColumn(name="idMedalla")} )
    private List<Medalla> medallas;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistorialPokemon> historial;

    public Entrenador() {

    }

    public Entrenador(String nombre, String ciudad, LocalDate fechaNacimiento, Pokemon pokemon) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.pokemon = pokemon;
        objetos = new ArrayList<>();
        medallas = new ArrayList<>();
        historial = new ArrayList<>();
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void addObjeto(Objeto obj){
        objetos.add(obj);
        obj.setEntrenador(this);
    }

    public List<Medalla> getMedallas() {
        return medallas;
    }

    public void setMedallas(ArrayList<Medalla> medallas) {
        this.medallas = medallas;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<Objeto> objetos) {
        this.objetos = objetos;
    }

    public List<HistorialPokemon> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<HistorialPokemon> historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", pokemon=" + pokemon +
                ", objetos=" + objetos +
                ", medallas=" + medallas +
                ", historial=" + historial +
                '}';
    }
}
