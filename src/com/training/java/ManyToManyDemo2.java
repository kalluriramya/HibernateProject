package com.training.java;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.training.java.util.HibernateUtil;

public class ManyToManyDemo2 {
	public static void main(String[] args) {
		SpeakerPOJO speaker = new SpeakerPOJO("Amzad Basha");
		Set<EventPOJO> events = new HashSet<EventPOJO>();
		events.add(new EventPOJO("Microsoft Seminar"));
		events.add(new EventPOJO("Oracle Seminar"));
		speaker.setEvents(events);
		Integer id = saveSpeakerData(speaker);
		getSpeakerData(id);
		System.exit(0);
	}

	private static void getSpeakerData(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SpeakerPOJO speaker = (SpeakerPOJO) session.get(SpeakerPOJO.class, id);
		if (speaker != null) {
			System.out.println("Speaker Name: " + speaker.getSpeakerName());
			System.out.println("Speaker Events: ");
			Set<EventPOJO> events = speaker.getEvents();
			for (EventPOJO event : events) {
				System.out.println("\t" + event.getEventName());
			}
		} else {
			System.out.println("No speaker exists with ID: " + id);
		}
		session.close();
	}

	private static Integer saveSpeakerData(SpeakerPOJO speaker) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Integer speakerId = null;
		try {
			transaction = session.beginTransaction();
			speakerId = (Integer) session.save(speaker);
			transaction.commit();
		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return speakerId;
	}
}