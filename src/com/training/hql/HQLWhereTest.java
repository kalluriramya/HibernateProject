package com.training.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.training.java.BookPOJO;
import com.training.java.util.HibernateUtil;

public class HQLWhereTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from BookPOJO where pub_id = :pubId");
		query.setInteger("pubId", 1);
		List<BookPOJO> books = query.list();
		for (BookPOJO book : books) {
			System.out.print(book.getBookId());
			System.out.print(" | " + book.getBookName());
			System.out.println(" | " + book.getPublisher().getPubName());
		}
		session.close();
		System.exit(0);
	}

}
