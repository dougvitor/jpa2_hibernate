package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteJPQL {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(2);

        Query query = manager
                .createQuery("select m from Movimentacao m where m.conta=:pConta and m.tipoMovimentacao = :pTipo order by m.valor desc");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id:" + m.getValor());
        }
    }


}
