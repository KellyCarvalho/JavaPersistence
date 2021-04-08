package application;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(0, "Kelly", "18kellycarvalho@gmail.com");
		System.out.println(p1);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, 1);//procura a pessoa com id 1
		System.out.println(p);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		//cria o objeto no banco de dados
		/*
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();*/
		em.close();
		emf.close();
		
	}

}
