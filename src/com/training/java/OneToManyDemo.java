package com.training.java;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.java.util.HibernateUtil;

public class OneToManyDemo {
	public static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		WriterPOJO writer = new WriterPOJO("Mohd. Arshad Basha");
		Set<StoryPOJO> stories = new HashSet<StoryPOJO>();
		stories.add(new StoryPOJO("About French"));
		stories.add(new StoryPOJO("Cartoon Movie"));
		stories.add(new StoryPOJO("Hyderabad City"));
		writer.setStories(stories);
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(writer);
			transaction.commit();
		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
			System.exit(0);
		}
	}

}
