package com.training.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.training.java.BookPOJO;
import com.training.java.util.HibernateUtil;

public class HQLSubQueryTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuilder queryString = new StringBuilder("FROM BookPOJO B ");
		queryString.append("WHERE B.publisher = ");
		queryString.append("(SELECT pubId FROM PublisherPOJO where pubId = :pubId)");

		Query query = session.createQuery(queryString.toString());
		query.setInteger("pubId", 6);
		List<BookPOJO> books = query.list();
		if (books.size() == 0) {
			System.out.println("No Books available.");
		} else {
			for (BookPOJO book : books) {
				System.out.print(book.getBookId());
				System.out.print(" | " + book.getBookName());
				System.out.println(" | " + book.getPublisher().getPubName());
			}
		}

		session.close();
		System.exit(0);
	}

}
