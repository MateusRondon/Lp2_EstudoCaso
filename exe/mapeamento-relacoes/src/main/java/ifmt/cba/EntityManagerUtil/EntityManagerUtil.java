package ifmt.cba.EntityManagerUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory entityManagerFactory = null;
    private EntityManagerUtil(){}
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory = null;
    }
    public static EntityManager getEntityManager getEntityManager() throws Exception{
        if(entityManagerFactory ==null){
            throw new Exception("Unidade de Persistenccia nao iniciada");
        }
        return entityManagerFactory.createEntityManager();
    }
}
