package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.model.Car;
import com.model.ShowRoom;

public class ShowroomTest {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration();
			
			cfg.addAnnotatedClass(ShowRoom.class);
			cfg.addAnnotatedClass(Car.class);
			cfg.configure("hibernate.cfg.xml");
			SessionFactory fact = cfg.buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
			
			ShowRoom sr = new ShowRoom();
			sr.setLocation("Bangalore");
			sr.setManager("Harish");
			
			Car shcar = new Car();
			shcar.setCarname("Audi");
			shcar.setColor("Red");
			
			sr.getShcar().add(shcar);
			shcar.getsr().add(sr);
			
			session.save(sr);
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	}

