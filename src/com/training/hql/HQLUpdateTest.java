package com.training.hql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.training.java.PublisherPOJO;
import com.training.java.util.HibernateUtil;

public class HQLUpdateTest {

	public static void main(String[] args) {
		System.out.println("Publishers List BEFORE Update:");
		System.out.println("-----------------------------------------");
		showPublishers();
		updatePublisher();

		System.out.println("--------------***************------------"); 
		System.out.println("Publishers List AFTER Update:"); 
		System.out.println("-----------------------------------------"); 
		showPublishers(); 
		System.exit(0);
	}
	private static void updatePublisher() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Update PublisherPOJO set pubName = :pubName where pubId = :pubId");
		query.setParameter("pubName", "TATA McGraw-Hill");
		query.setParameter("pubId", 4);
		Transaction transaction = session.beginTransaction();
		int i = query.executeUpdate();
		transaction.commit();
		System.out.println("No. of rows affected: " + i);
		session.close();
	}
	private static void showPublishers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from PublisherPOJO");
		List<PublisherPOJO> pubs = query.list();
		for (PublisherPOJO pub : pubs) {
			System.out.println(pub.getPubId() + " | " + pub.getPubName());
		}
		session.close();
	}

}
