package ifmt.cba.execucao;

import java.util.List;

import ifmt.cba.entity.Cliente;
import ifmt.cba.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppConsultarClienteNomeOrdemCrescente {

    public static void main(String[] args) {
        
        try{
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT p FROM Cliente p ORDER BY p.nome ASC");
            List<Cliente> listaCliente = query.getResultList();
            System.out.println("-------------------------------------------------");
            System.out.println("Consulta de cliente ordenados pelo nome em ordem crescente");
            for(Cliente p :listaCliente){
                System.out.println("Codigo cliente: " +p.getCodigo());
                System.out.println("Nome do cliente: "+p.getNome());
                System.out.println("RG: "+p.getRG());
                System.out.println("CPF: "+p.getCPF());
                System.out.println("Logradouro: "+p.getLogradouro());
                System.out.println("Numero: "+p.getNumero());
                System.out.println("Ponto de referencia: "+p.getPontoReferencia());
                System.out.println("Telefone do cliente: "+p.getTelefone());
                System.out.println("-------------------------------------------------");
            }
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
