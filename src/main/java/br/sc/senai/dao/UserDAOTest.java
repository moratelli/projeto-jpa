package br.sc.senai.dao;

import br.sc.senai.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {

	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory("users-db");

		entityManager = factory.createEntityManager();

		update();

		delete();

		entityManager.close();
		factory.close();
	}

	public static void insert() {
		entityManager.getTransaction().begin();

		User newUser = new User();
		newUser.setEmail("pedromoratelli@gmail.com");
		newUser.setFullname("Pedro Moratelli");
		newUser.setPassword("senhasecreta");

		entityManager.persist(newUser);

		entityManager.getTransaction().commit();

	}

	public static void update() {
		entityManager.getTransaction().begin();

		User updatedUser = entityManager.find(User.class, 1);

		updatedUser.setFullname("Bill Gates");
		updatedUser.setEmail("bill.gates@microsoft.com");

		entityManager.merge(updatedUser);

		entityManager.getTransaction().commit();
	}

	public static void delete() {
		entityManager.getTransaction().begin();

		User user = entityManager.find(User.class, 2);

		entityManager.remove(user);

		entityManager.getTransaction().commit();
	}
}