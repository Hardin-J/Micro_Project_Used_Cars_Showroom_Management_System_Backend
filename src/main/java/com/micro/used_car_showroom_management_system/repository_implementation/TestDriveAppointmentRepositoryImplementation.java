package com.micro.used_car_showroom_management_system.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.used_car_showroom_management_system.model.TestDriveAppointment;
import com.micro.used_car_showroom_management_system.repository.TestDriveAppointmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TestDriveAppointmentRepositoryImplementation implements TestDriveAppointmentRepository{

	EntityManager em;
	
	public TestDriveAppointmentRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public TestDriveAppointment save(TestDriveAppointment testDriveAppointment) {
		em.persist(testDriveAppointment);
		return testDriveAppointment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestDriveAppointment> listAllAppointments() {
		String hql = "from TestDriveAppointment";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestDriveAppointment> listAllAppointmentsForSingleUser(long id) {
		String hql = "select tda from TestDriveAppointment tda where customer.id = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestDriveAppointment> listAllAppointmentsForSingleCar(long id) {
		String hql = "select tda from TestDriveAppointment tda where cars.id = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public TestDriveAppointment updateCancelStatus(TestDriveAppointment testDriveAppointment) {
		return em.merge(testDriveAppointment);
	}

	@Override
	public TestDriveAppointment findSingleAppointmentById(long id) {
		TestDriveAppointment appointment = em.find(TestDriveAppointment.class, id);
		return appointment;
	}

	@Override
	public long countOfAllAppointments() {
		String hql = "select count(tda) from TestDriveAppointment tda";
	    Query query = em.createQuery(hql);
	    return (Long) query.getSingleResult();
	}

}
