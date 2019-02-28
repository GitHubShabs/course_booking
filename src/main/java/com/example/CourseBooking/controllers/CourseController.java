package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesByRating(@PathVariable int rating){
        return courseRepository.getAllCoursesByRating(rating);
    }

    @GetMapping(value = "/customer/{customerId}")
    public List<Course> getCustomersByCourseId(@PathVariable Long customerId){
        return courseRepository.getCoursesForCustomerId(customerId);
    }

}
