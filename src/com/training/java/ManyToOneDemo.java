package com.training.java;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.java.util.HibernateUtil;

public class ManyToOneDemo {
	
	public static Session session = HibernateUtil.getSessionFactory().openSession();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WriterPOJO writer1 = new WriterPOJO("Mohd. Afsar Basha");
		StoryPOJO story1 = new StoryPOJO("Superman Story", writer1);
		StoryPOJO story2 = new StoryPOJO("Spiderman Story", writer1);
		StoryPOJO story3 = new StoryPOJO("Batman Story", writer1);
	
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();
		session.save(story1);
		session.save(story2);
		session.save(story3);
		transaction.commit();
		} catch(HibernateException ex) {
		if (transaction!=null) {
		transaction.rollback();
		}
		ex.printStackTrace();
		} finally{
		session.close();
		System.exit(0);
		}
		
	}

}
