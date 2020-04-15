package br.sc.senai.dao;

import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("users-db");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		User newUser = new User();
		newUser.setEmail("arthurufelix@gmail.com");
		newUser.setFullname("Arthur Felix");
		newUser.setPassword("senhasecreta");

		entityManager.persist(newUser);

		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();
	}
}
