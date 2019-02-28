package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    public List<Course> getCoursesForCustomerId(Long customerId);
}
