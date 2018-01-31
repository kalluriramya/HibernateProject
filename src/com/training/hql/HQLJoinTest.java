package com.training.hql;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.training.java.util.HibernateUtil;

public class HQLJoinTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String queryString = "Select B.bookId, B.bookName, P.pubId, P.pubName "
				+ " from BookPOJO B, PublisherPOJO P where B.publisher = P.pubId";
		Query query = session.createQuery(queryString);
		List<?> list = query.list();
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) 
		{
			Object[] obj = (Object[]) iterator.next();
			for (int i = 0; i < obj.length; i++) 
			{
				System.out.print(obj[i] + " | ");
			}
			System.out.println();
		}

		session.close();
		System.exit(0);
	}

}
