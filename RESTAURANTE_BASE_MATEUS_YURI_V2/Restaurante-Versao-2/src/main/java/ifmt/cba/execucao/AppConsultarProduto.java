package ifmt.cba.execucao;


import java.util.List;

import ifmt.cba.entity.Produto;
import ifmt.cba.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppConsultarProduto {

    public static void main(String[] args) {
        

        try{
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT p FROM Produto p ORDER BY p.nome ASC");
            List<Produto> listaProduto = query.getResultList();
            System.out.println("-------------------------------------------------");
            System.out.println("Consulta nomes de produtos ordenados em ordem crescente");
            for(Produto p :listaProduto){
                System.out.println("Codigo produto: " +p.getCodigo());
                System.out.println("Nome produto: "+p.getNome());
                System.out.println("-------------------------------------------------");
            }
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
