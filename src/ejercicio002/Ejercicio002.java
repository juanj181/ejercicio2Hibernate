/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio002;

import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Jj
 */
public class Ejercicio002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        
        //objero a insertar:
        java.util.Date ahora=new java.util.Date();
        Seguro seguro1 = new Seguro(33, "434353", "pepe", "nevado", "tena", 43, 2, new Timestamp (ahora.getTime()));
        Seguro seguro2 = new Seguro(30, "949494", "juan", "garcia", "gascon", 23, 1, new Timestamp (ahora.getTime()));
        
        //abrimos la sesion
        Session session = sessionFactory.openSession();
        
        //insertar
        session.beginTransaction();
        session.save(seguro1);
        session.getTransaction().commit();
        
        
        //leer
        Seguro seguro = (Seguro)session.get(Seguro.class,33);
        
        
        //actualizar
        session.beginTransaction();
        session.update(seguro2);
        session.getTransaction().commit();
        
        //borrar
        session.beginTransaction();
        session.delete(seguro1);
        session.getTransaction().commit();
        
        
        //guardar o actualizar(insertar o actualizar)
        session.beginTransaction();
        session.saveOrUpdate(seguro2);
        session.getTransaction();
        
        
        //cerramos la sesion
        session.close();
        sessionFactory.close();


    }
}
