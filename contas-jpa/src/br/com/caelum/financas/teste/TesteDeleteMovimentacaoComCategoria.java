package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteDeleteMovimentacaoComCategoria {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		 
		 em.getTransaction().begin();
		 
		 em.remove(em.find(Movimentacao.class, 2));
		 
		 em.getTransaction().commit();
		 
		 em.close();
		
	}

}
