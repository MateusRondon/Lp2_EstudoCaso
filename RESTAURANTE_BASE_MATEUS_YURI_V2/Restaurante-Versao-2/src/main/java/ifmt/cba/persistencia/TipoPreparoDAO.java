package ifmt.cba.persistencia;

import java.util.List;

import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.entity.TipoPreparo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class TipoPreparoDAO extends DAO <TipoPreparo>{

    public TipoPreparoDAO(EntityManager entityManager) throws PersistenciaException{
        super(entityManager);
    }

    public TipoPreparo buscarPorCodigo (int codigo)throws PersistenciaException{
        
        TipoPreparo tipoPreparo =null;
        try {
            tipoPreparo = this.entityManager.find(TipoPreparo.class, codigo);
    
        }catch(Exception ex){
            throw new PersistenciaException("Erro na selecao por codigo -->"+ex.getMessage());
        }
        return tipoPreparo;
    }


    @SuppressWarnings("unchecked")
        public List <TipoPreparo>buscarPorDescricao(String descricao )throws PersistenciaException{
            List <TipoPreparo> listaTipoPreparo;
            try{
                Query query = this.entityManager.createQuery("SELECT p FROM TipoPreparo p WHERE UPPER (p.descricao) LIKE:pDescricao ORDER BY p.descricao");
                query.setParameter("pDescricao", "%"+descricao.toUpperCase().trim()+"%");
                listaTipoPreparo = query.getResultList();
            }catch(Exception ex){
                throw new PersistenciaException("Erro na selecao por parte Nome-->"+ex.getMessage());
            }
            return listaTipoPreparo;
        }

        public void excluir(TipoPreparoDTO tipoPreparo) {
          
            throw new UnsupportedOperationException("Unimplemented method 'excluir'");
        }




}
