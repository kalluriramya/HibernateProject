package com.training.java;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.java.util.HibernateUtil;

public class ManyToManyDemo1 {
	public static void main(String[] args) {
		EventPOJO event = new EventPOJO("Hibernate Seminar");
		Set<SpeakerPOJO> speakers = new HashSet<SpeakerPOJO>();
		speakers.add(new SpeakerPOJO("Mohd. Arshad Basha"));
		speakers.add(new SpeakerPOJO("Mohd. Afsar Basha"));
		event.setSpeakers(speakers);
		Integer id = saveEventData(event);
		getEventData(id);
		System.exit(0);

	}

	private static void getEventData(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EventPOJO event = (EventPOJO) session.get(EventPOJO.class, id);
		if (event != null) {
			System.out.println("Event Name: " + event.getEventName());
			System.out.println("Event Speakers: ");
			Set<SpeakerPOJO> speakers = event.getSpeakers();
			for (SpeakerPOJO speaker : speakers) {
				System.out.println("\t" + speaker.getSpeakerName());
			}
		} else {
			System.out.println("No event exists with ID: " + id);
		}
		session.close();
	}

	private static Integer saveEventData(EventPOJO event) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer eventId = null;
		try 
		{
			transaction = session.beginTransaction();
			eventId = (Integer) session.save(event);
			transaction.commit();
		} 
		catch (HibernateException ex) 
		{
			if (transaction != null) 
			{
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
		finally 
		{
			session.close();
		}
		return eventId;

	}

}
