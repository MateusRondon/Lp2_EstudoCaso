package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Pessoa1;
import ifmt.cba.vo.PessoaJuridica1;
import ifmt.cba.vo.PessoaFisica1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("Unchecked")
public class AppPessoa1c {
    public static void main(String[] args) {
        try{
         EntityManager entityManager = EntityManagerUtil.getEntityManager();
         entityManager.getTransaction().begin();
         Query query = entityManager.createQuery("SELECT p FROM Pessoa1 p ORDER BY p.codigo");
         List<Pessoa1> listaPessoa1 = query.getResultList();
        System.out.println("--------------------------------");
            for(Pessoa1 pessoa: listaPessoa1){
                System.out.println("Codigo...........:"+pessoa.getCodigo());
                System.out.println("Nome............:"+pessoa.getNome());
                System.out.println("Rendimentos.............:"+pessoa.getRendimento());
                System.out.println();
            }
        System.out.println("--------------------------------");

        //PessoaFisica1
        query = entityManager.createQuery("SELECT p FROM PessoaFisica1 p ORDER BY p.codigo");
        List<PessoaFisica1> listaPessoaFisica1 = query.getResultList();
            for(PessoaFisica1 pessoa: listaPessoaFisica1){
                System.out.println("Codigo...........:"+pessoa.getCodigo());
                System.out.println("Nome............:"+pessoa.getNome());
                System.out.println("Rendimentos.............:"+pessoa.getRendimento());
                System.out.println();
            }
        System.out.println("--------------------------------");

        //PessoaJuridica1
        query = entityManager.createQuery("SELECT p FROM PessoaJuridica1 p ORDER BY p.codigo");
        List<PessoaJuridica1> listaPessoaJuridica1 = query.getResultList();
            for(PessoaJuridica1 pessoa: listaPessoaJuridica1){
                System.out.println("Codigo...........:"+pessoa.getCodigo());
                System.out.println("Nome............:"+pessoa.getNome());
                System.out.println("Rendimentos.............:"+pessoa.getRendimento());
                System.out.println();
            }
        System.out.println("--------------------------------");
        entityManager.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
