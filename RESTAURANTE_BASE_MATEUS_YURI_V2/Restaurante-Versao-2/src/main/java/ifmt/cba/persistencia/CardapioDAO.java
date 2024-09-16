package ifmt.cba.persistencia;

import java.util.List;
import ifmt.cba.entity.Cardapio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CardapioDAO extends DAO<Cardapio>{


    public CardapioDAO(EntityManager entityManager) throws PersistenciaException {
        super(entityManager);
    }

     public Cardapio buscarPorCodigo(int codigo) throws PersistenciaException {
        Cardapio cardapio = null;
        try {
            cardapio = this.entityManager.find(Cardapio.class, codigo);
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por codigo - " + ex.getMessage());
        }
        return cardapio;
    }

    /*public Cliente buscarPorCPF(String CPF) throws PersistenciaException {
        Cliente cliente;
        try {
            Query query = this.entityManager
                    .createQuery("SELECT c FROM Cliente c WHERE UPPER(c.CPF) = :pCPF");
            query.setParameter("pCPF", CPF.toUpperCase().trim());
            cliente = (Cliente) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            cliente = null;
        } catch (Exception ex) {
            cliente = null;
            throw new PersistenciaException("Erro na selecao por CPF - " + ex.getMessage());
        }
        return cliente;
    }*/

    @SuppressWarnings("unchecked")
    public List<Cardapio> buscarPorParteNome(String nome) throws PersistenciaException {
        List<Cardapio> listaCardapio;
        try {
            Query query = this.entityManager
                    .createQuery("SELECT c FROM Cardapio c WHERE UPPER(c.nome) LIKE :pNome ORDER BY c.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaCardapio = query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por parte do nome - " + ex.getMessage());
        }
        return listaCardapio;
    } 
}
