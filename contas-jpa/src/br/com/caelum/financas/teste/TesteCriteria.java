package br.com.caelum.financas.teste;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		  EntityManager manager = new JPAUtil().getEntityManager();
		  
		  CriteriaBuilder builder = manager.getCriteriaBuilder();
		  
		  CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		  Root<Movimentacao> root = query.from(Movimentacao.class);
		  
		  query.where(builder.like(root.<String>get("descricao"), "Estacionamento")/*builder.lessThan(root.<Calendar>get("data"), builder.parameter(Calendar.class, "data"))*/);
		  
		  Calendar c = Calendar.getInstance();
		  c.set(2018, 4, 26);
		  
		  TypedQuery<Movimentacao> typedQuery = manager.createQuery(query);
		 // typedQuery.setParameter("data", c);
		  
		  System.out.println(typedQuery.getResultList());
	}

}
