package br.sc.senai.dao;

import br.sc.senai.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAOTest {

	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory("users-db");

		entityManager = factory.createEntityManager();

		insert();
		//  update();
		//  delete();

		entityManager.close();
		factory.close();
	}

	public static void insert() {
		entityManager.getTransaction().begin();

		Pessoa newPessoa = new Pessoa();
		newPessoa.setNome("Pedro");
		newPessoa.setSobrenome("Moratelli");
		newPessoa.setCpf(888288888);

		entityManager.persist(newPessoa);

		entityManager.getTransaction().commit();

	}

	public static void update() {
		entityManager.getTransaction().begin();

		Pessoa updatedPessoa = entityManager.find(Pessoa.class, 1);

		updatedPessoa.setNome("Bill");
		updatedPessoa.setSobrenome("Gates");
		updatedPessoa.setCpf(899910907);

		entityManager.merge(updatedPessoa);

		entityManager.getTransaction().commit();
	}

	public static void delete() {
		entityManager.getTransaction().begin();

		Pessoa pessoa = entityManager.find(Pessoa.class, 2);

		entityManager.remove(pessoa);

		entityManager.getTransaction().commit();
	}
}