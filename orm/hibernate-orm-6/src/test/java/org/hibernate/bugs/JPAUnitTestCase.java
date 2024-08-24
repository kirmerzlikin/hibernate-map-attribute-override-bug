package org.hibernate.bugs;

import java.time.LocalTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


class JPAUnitTestCase {

	@Test
	void hhh18516Test() {
		// Exception gets thrown here
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(new Schedule(Map.of(
				new Route("Hamburg", "Vienna"), LocalTime.NOON,
				new Route("Warsaw", "Barcelona"), LocalTime.MIDNIGHT
		)));
		entityManager.flush();

		entityManager.getTransaction().commit();
		entityManager.close();

		entityManagerFactory.close();
	}

}
