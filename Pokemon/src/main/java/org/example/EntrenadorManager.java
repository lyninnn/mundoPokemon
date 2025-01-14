package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class EntrenadorManager {

    //Conexión con la unidad persistencia
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");


    //Insertamos entrenador
    public static void insertEntrenador(Entrenador entrenador){
        EntityManager manager = managerFactory.createEntityManager(); //Creamos conexión con el ORM
        manager.getTransaction().begin(); //FUNCIONA POR TRANSACCIONES
        manager.persist(entrenador);//Insertar
        manager.getTransaction().commit();
        manager.close();
    }
    public static void insertPokemon(Pokemon pokemon){
        EntityManager manager = managerFactory.createEntityManager(); //Creamos conexión con el ORM
        manager.getTransaction().begin(); //FUNCIONA POR TRANSACCIONES
        manager.persist(pokemon);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void updateEntrenador(Entrenador entrenador){
        EntityManager manager = managerFactory.createEntityManager(); //Creamos conexión con el ORM
        manager.getTransaction().begin();
        manager.merge(entrenador); //UPDATE
        manager.getTransaction().commit();
        manager.close();
    }

    public static void deleteEntrenador(Entrenador entrenador){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Entrenador e = manager.find(Entrenador.class, entrenador.getId()); //hay que buscarlo primero
        manager.remove(e);
        manager.getTransaction().commit();
        manager.close();
    }

    public static String getNombre(int id){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Entrenador e = manager.find(Entrenador.class, id);
        manager.getTransaction().commit();
        manager.close();
        return e.getNombre();
    }

    public static Entrenador getEntrenadorByNombre(String name){  //JPQL
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        //no es la tabla es la clase :D
        TypedQuery<Entrenador> query =
                manager.createQuery("FROM Entrenador where nombre = :nombre", Entrenador.class);
        query.setParameter("nombre", name);
        Entrenador e  = query.getSingleResult();//Si existe más de uno en la BBDD da error
      //Entrenador e = query.getResultList().stream().findFirst().orElse(null);//LIMIT 1
        manager.getTransaction().commit();
        manager.close();
        return e;
    }

    public static ArrayList<Entrenador> getEntrenadores(){  //JPQL
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Entrenador> query =
                manager.createQuery("FROM Entrenador", Entrenador.class);
        ArrayList<Entrenador> listado  = new ArrayList<>(query.getResultList());
        manager.getTransaction().commit();
        manager.close();
        return listado;
    }







}
