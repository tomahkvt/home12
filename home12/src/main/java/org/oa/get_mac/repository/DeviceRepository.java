package org.oa.get_mac.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oa.get_mac.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DeviceRepository {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public DeviceRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Device item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void update(Device item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public void delete(Device item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
	}

	public List<Device> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Device");
		List<Device> result = query.list();

		session.getTransaction().commit();
		return result;
	}
	
	public Device findById(int idDevice) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Device result  = session.get(Device.class, idDevice);
		System.out.println(result);
		session.getTransaction().commit();
		return result;
	}
	
	
	
	
	
}
