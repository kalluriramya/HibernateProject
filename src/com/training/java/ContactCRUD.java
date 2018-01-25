package com.training.java;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.java.util.HibernateUtil;

public class ContactCRUD {
	public static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		//Integer contactId = insertContact();
		getAllContacts();
		
		//getContact(2); 
		//updateContact(2, "Mohammed Arshad"); 
		//getContact(2);
		
		//getContact(4); 
		//deleteContact(4); 
		//getContact(4);

		session.close();
		System.exit(0);
	}
	private static void deleteContact(int id) 
	{
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 
			ContactPOJO contact = (ContactPOJO) session.get(ContactPOJO.class, id); 
			 
			session.delete(contact); 
			transaction.commit(); 
			} 
		catch (HibernateException e) 
		{ 
			if (transaction != null) 
			{ 
				transaction.rollback(); 
			} 
			e.printStackTrace(); 
		}
	}
	private static void updateContact(int id, String firstName) 
	{
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 
			ContactPOJO contact = (ContactPOJO) session.get(ContactPOJO.class, id); 
			contact.setFirstName(firstName); 
			session.update(contact); 
			transaction.commit(); 
			} 
		catch (HibernateException e) 
		{ 
			if (transaction != null) 
			{ 
				transaction.rollback(); 
			} 
			e.printStackTrace(); 
		}
		
	}
	private static void getContact(int id) 
	{
		ContactPOJO contact = (ContactPOJO) session.get(ContactPOJO.class, id); 
		if (contact!=null) 
		{ 
			System.out.println(contact.toString()); 
		} 
		else 
		{ 
			System.out.println("No contact exists with ID: " + id); 
		}
		
	}
	private static Integer insertContact() 
	{
		
		Integer contactId = null;
		Transaction transaction = null;

		try{ 
			transaction = session.beginTransaction(); 
			ContactPOJO contact = new ContactPOJO(); 
			contact.setFirstName("Afsar"); 
			contact.setLastName("Basha"); 
			contact.setDob(new Date("08/16/2008")); 
			contact.setEmail("amzad.basha@gmail.com");
			contact.setMobile("+91-9391001339"); 
			contactId = (Integer) session.save(contact); 
			transaction.commit(); 
			} 
		catch(HibernateException ex) 
		{ 
			if (transaction!=null) 
			{ 
				transaction.rollback(); 
			} 
			ex.printStackTrace(); 
			
		} 
		return contactId;
	}

	private static void getAllContacts() 
	{
		List<ContactPOJO> contacts = session.createQuery("from ContactPOJO").list();
		for (ContactPOJO contact : contacts) {
			System.out.println(contact.toString());
		}
	}

}
