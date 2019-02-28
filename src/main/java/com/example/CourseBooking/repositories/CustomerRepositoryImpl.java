package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getCustomersForGivenCourse(Long courseId){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            results = cr.list();

        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {

        }

        return results;
    }

    @Transactional
    public List<Customer> getCustomersForGivenCourseOfTown(Long courseId){
        List<Customer> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            cr.add(Restrictions.eq("booking.course.town", "booking.customer.town"));
            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {

        }


        return results;
    }


}
