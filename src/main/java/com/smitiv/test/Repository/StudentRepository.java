package com.smitiv.test.Repository;

import com.smitiv.test.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRollNumber(Integer rollNumber);

    Student findByPhoneNumber(String rollNumber);


    @Query("select s.id from Student s where s.id=?1")
    Long findByStudentId(Long id);

    @Query("select s from Student s where s.id=?1")
    Student findByStudent(Long id);
}
