package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    public List<Customer> getCustomersForGivenCourse(Long courseId);
    public List<Customer> getCustomersForGivenCourseOfTown(Long courseId);
}
