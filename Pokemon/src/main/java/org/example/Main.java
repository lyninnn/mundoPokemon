package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Entrenador e = new Entrenador("Lin", "Galdar", LocalDate.of(2000, 10, 4), new Pokemon("Charmander", TIPO1.fuego, TIPO1.fuego));

        EntrenadorManager.insertEntrenador(e);

    }
}