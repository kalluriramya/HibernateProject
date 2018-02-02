package com.training.hql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.training.java.BookPOJO;
import com.training.java.PublisherPOJO;
import com.training.java.util.HibernateUtil;

public class CriteriaTest4 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

		Root<BookPOJO> bookRoot = criteria.from(BookPOJO.class);
		Root<PublisherPOJO> publisherRoot = criteria.from(PublisherPOJO.class);
		criteria.multiselect(bookRoot, publisherRoot);
		criteria.where(builder.equal(bookRoot.get("publisher"), publisherRoot.get("pubId")));

		// Use criteria to query with session
		Query<Object[]> query = session.createQuery(criteria);
		List<Object[]> list = query.getResultList();
		for (Object[] obj : list) {
			BookPOJO bookObj = (BookPOJO) obj[0];
			PublisherPOJO pubObj = (PublisherPOJO) obj[1];
			System.out.println(bookObj.getBookId() + " | " + bookObj.getBookName() + " | " + pubObj.getPubName());

		}
	}

}
