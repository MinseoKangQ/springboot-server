package com.server.sumnote;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SumNoteApplication {

	public static void main(String[] args) {

		SpringApplication.run(SumNoteApplication.class, args);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sum-note");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // 트랜잭션 시작

		System.out.println("Transaction start");

		try {

			tx.commit();
			System.out.println("try end!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("catch");
			tx.rollback();
		} finally {
			System.out.println("finally");
			em.close();
		}
		emf.close();


	}

}
