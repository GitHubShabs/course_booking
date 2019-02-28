package com.example.CourseBooking.components;

import com.example.CourseBooking.models.Booking;
import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.BookingRepository;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Andrew MacLeod", "Peterhead", 21);
        customerRepository.save(customer1);

        Course course1 = new Course("Intro to Python", "Peterhead", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Intro to Java", "Aberdeen", 5);
        courseRepository.save(course2);

        Booking booking1 = new Booking("22-03-19", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("22-04-19", customer1, course2);
        bookingRepository.save(booking2);

    }
}
