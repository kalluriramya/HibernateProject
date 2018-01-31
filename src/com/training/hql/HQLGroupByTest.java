package com.training.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.training.java.util.HibernateUtil;

public class HQLGroupByTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "SELECT B.publisher.pubName, COUNT(B.bookId) FROM BookPOJO B GROUP BY B.publisher.pubName";
		Query query = session.createQuery(queryString);
		List<?> list = query.list();
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) 
		{
			Object[] row = (Object[]) iterator.next();
			System.out.print("Publisher: " + row[0]);
			System.out.println(" | Number of Books: " + row[1]);
		}

		session.close();
		System.exit(0);
	}

}
