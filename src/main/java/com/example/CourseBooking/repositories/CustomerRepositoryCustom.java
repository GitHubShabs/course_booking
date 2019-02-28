package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    public List<Customer> getCustomersForGivenCourse(Long courseId);

}
