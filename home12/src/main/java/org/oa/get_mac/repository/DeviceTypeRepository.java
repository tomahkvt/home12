package org.oa.get_mac.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oa.get_mac.model.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DeviceTypeRepository {

	private final SessionFactory sessionFactory;
	@Autowired
	public DeviceTypeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(DeviceType item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void update(DeviceType item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public void delete(DeviceType item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
	}

	public List<DeviceType> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM DeviceType");
		List<DeviceType> result = query.list();

		session.getTransaction().commit();
		return result;
	}
}
