package com.training.hql;

import org.hibernate.Session;
import com.training.java.BookPOJO;
import com.training.java.util.HibernateUtil;

public class SessionLoadTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			int id = 50;
			BookPOJO book = (BookPOJO) session.load(BookPOJO.class, id);
			if (book != null) {
				System.out.println(book.getBookId() + " | " + book.getBookName());

			} else {
				System.out.println("No book available with ID: " + id);

			}

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		} finally {
			session.close();
			System.exit(0);
		}
	}
}
