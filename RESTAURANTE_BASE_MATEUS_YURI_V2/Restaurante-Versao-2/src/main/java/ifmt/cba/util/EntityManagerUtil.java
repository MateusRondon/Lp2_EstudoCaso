package ifmt.cba.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory entityManagerFactory =null;

    private EntityManagerUtil(){}

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("restaurante_producao");
    }

    public static EntityManager getEntityManager() throws Exception{
        if (entityManagerFactory == null) {
            throw new Exception("Unidade de Persistencia nao iniciada");
        }
        return entityManagerFactory.createEntityManager();
    }
}
