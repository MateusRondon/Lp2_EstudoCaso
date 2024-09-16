package ifmt.cba.persistencia;


import java.util.List;
import ifmt.cba.entity.PreparoProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PreparoProdutoDAO extends DAO<PreparoProduto>{


    public PreparoProdutoDAO(EntityManager entityManager) throws PersistenciaException{
        super(entityManager);
    }


    public PreparoProduto buscarPorCodigo(int codigo) throws PersistenciaException {
        PreparoProduto preparoProduto = null;

        try {
            preparoProduto = this.entityManager.find(PreparoProduto.class, codigo);
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por codigo - " + ex.getMessage());
        }
        return preparoProduto;
    }

    @SuppressWarnings("unchecked")
    public List <PreparoProduto> buscarPorParteNome(String nome) throws PersistenciaException {
        List<PreparoProduto> listaPreparoProduto;
        try {
            Query query = this.entityManager
                    .createQuery("SELECT c FROM PreparoProduto c WHERE UPPER(c.nome) LIKE :pNome ORDER BY c.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaPreparoProduto = query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por parte do nome - " + ex.getMessage());
        }
        return listaPreparoProduto;
    }

    @SuppressWarnings("unchecked")
    public List <PreparoProduto> buscarPorProduto(int idProduto) throws PersistenciaException {
        List<PreparoProduto> listaPreparoProduto;
        try {
            Query query = this.entityManager
                    .createQuery("SELECT c FROM PreparoProduto c WHERE c.produto.codigo = :pProduto");
            query.setParameter("pProduto",idProduto);
             listaPreparoProduto = query.getResultList();

        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por produto - " + ex.getMessage());
        }

        return listaPreparoProduto;
    }

    @SuppressWarnings("unchecked")
    public List <PreparoProduto> buscarPorTipoPreparo(int idPreparo) throws PersistenciaException {
        List<PreparoProduto> listaPreparoProduto;
        try {
            Query query = this.entityManager
                    .createQuery("SELECT c FROM PreparoProduto c WHERE c.tipoPreparo.codigo = :pTipoPreparo ORDER BY c.tipoPreparo");
            query.setParameter("pTipoPreparo",idPreparo);
             listaPreparoProduto = query.getResultList();

        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por tipo preparo - " + ex.getMessage());
        }

        return listaPreparoProduto;
    }


}
