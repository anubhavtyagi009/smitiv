package com.smitiv.test.Repository;

import com.smitiv.test.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRollNumber(Integer rollNumber);

    Student findByPhoneNumber(String rollNumber);
}
