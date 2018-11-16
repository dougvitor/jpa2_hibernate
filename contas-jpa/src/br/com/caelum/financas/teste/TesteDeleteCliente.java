package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.util.JPAUtil;

public class TesteDeleteCliente {
	
	public static void main(String[] args) {
		
		 EntityManager em = new JPAUtil().getEntityManager();
		 
		 em.getTransaction().begin();
		 
		 em.remove(em.find(Cliente.class, 1));
		 
		 em.getTransaction().commit();
		 
		 em.close();
	}

}
