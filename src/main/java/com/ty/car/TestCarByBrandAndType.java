package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestCarByBrandAndType {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		//String sql=;
		Query query=entityManager.createQuery("SELECT c FROM ty_car c WHERE u.brand=?1 AND u.type=?2");
		query.setParameter(1, "XUV");
		query.setParameter(2, "Manual");
		
		List<Car> cars=query.getResultList();
		if(cars.size() > 0) {
			for (Car car : cars) {
				System.out.println("Name : "+car.getName());
				System.out.println("Brand : "+car.getBrand());
				System.out.println("Cost : "+car.getCost());
				System.out.println("Type : "+car.getType());
			}
		}
		else {
			System.out.println("Sorry no cars available");
		}
		
	}
}
