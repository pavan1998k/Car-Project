package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestUserByEmailAndPassword {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();


		String sql="SELECT u FROM User u WHERE u.email=?1 AND u.password=?2";
		Query Query=entityManager.createQuery(sql);
		List<User> users= Query.getResultList();
		Query.setParameter(1, "rami@gmail.com");
		Query.setParameter(2, "1234ramesh");

		if(users.size() > 0) {

			User user=users.get(0);
			System.out.println("Name: "+user.getName());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Gender: "+user.getGender());

		}
		else {

			System.out.println("Invalid user");
		}
	}



}

