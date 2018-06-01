package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteFuncaoJPQL {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo" +
                " group by m.data";

        TypedQuery<Double> query = manager.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> resultado = query.getResultList();

        System.out.println("Total movimentado ..: R$ " + resultado);
        
        TypedQuery<Double> namedQuery = manager.createNamedQuery("valorMedia", Double.class);
        
        namedQuery.setParameter("pConta", conta);
        namedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);

        System.out.println("Total movimentado ..: R$ " + namedQuery.getResultList());
        
    }

}

