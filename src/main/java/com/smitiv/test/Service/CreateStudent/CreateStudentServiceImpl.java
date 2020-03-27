package com.smitiv.test.Service.CreateStudent;

import com.smitiv.test.Domain.Student;
import com.smitiv.test.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentServiceImpl implements CreateStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public CreateStudentResponse execute(CreateStudentDTO createStudentDTO) {
        CreateStudentResponse response = null;
        Student student = new Student();
        try {
            //validate request
            validateRequest(createStudentDTO);

            //save student info
            student.setName(createStudentDTO.getName());
            student.setAge(createStudentDTO.getAge());
            student.setGender(createStudentDTO.getGender());
            student.setRollNumber(createStudentDTO.getRollNumber());
            student.setPhoneNumber(createStudentDTO.getPhoneNumber());
            student.setAddress(createStudentDTO.getAddress());
            studentRepository.save(student);

            //set success response
            response = new CreateStudentResponse();
            response.SUCCESSFUL = true;
            response.setId(student.getId());
            response.setMessage("Successfully saved student info");
        } catch (Exception e) {
            //set failure response
            response = new CreateStudentResponse();
            response.SUCCESSFUL = false;
            response.setMessage("Failure" + ":" + e.getMessage());
        }
        return response;
    }

    private void validateRequest(CreateStudentDTO createStudentDTO) throws Exception {
        if (createStudentDTO.getName() == null || createStudentDTO.getName().isEmpty()) {
            throw new Exception("Name should not be empty or null");
        }
        if (createStudentDTO.getAge() == null) {
            throw new Exception("Age should not be empty or null");
        }
        if (createStudentDTO.getGender() == null || createStudentDTO.getGender().isEmpty()) {
            throw new Exception("Gender should not be empty or null");
        }
        if (createStudentDTO.getRollNumber() == null) {
            throw new Exception("RollNumber should not be empty or null");
        }
        if (createStudentDTO.getPhoneNumber() == null || createStudentDTO.getPhoneNumber().isEmpty()) {
            throw new Exception("PhoneNumber should not be empty or null");
        }
        Student rollNumber = studentRepository.findByRollNumber(createStudentDTO.getRollNumber());
        if (rollNumber != null) {
            throw new Exception("Student with given rollNumber already exist");
        }
        Student phoneNumber = studentRepository.findByPhoneNumber(createStudentDTO.getPhoneNumber());
        if (phoneNumber != null) {
            throw new Exception("Student with given phoneNumber already exist");
        }
    }
}
