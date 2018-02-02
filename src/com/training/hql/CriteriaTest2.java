package com.training.hql;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import com.training.java.BookPOJO;
import com.training.java.util.HibernateUtil;

public class CriteriaTest2 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery 
		CriteriaQuery<BookPOJO> criteria = builder.createQuery(BookPOJO.class); 
		Root<BookPOJO> bookRoot = criteria.from(BookPOJO.class); 
		criteria.select(bookRoot).where(builder.equal(bookRoot.get("publisher"),5));
		
		//Use criteria to query with session to fetch all contacts 
		List<BookPOJO> books = session.createQuery(criteria).getResultList();
		for (BookPOJO book : books) {
			System.out
					.println(book.getBookId() + " | " + book.getBookName() + " | " + book.getPublisher().getPubName());
		}
		session.close();
		System.exit(0);
	}

}
