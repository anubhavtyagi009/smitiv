package com.smitiv.test.Service.UpdateStudent;

import com.smitiv.test.Domain.Student;
import com.smitiv.test.Repository.StudentRepository;
import com.smitiv.test.Service.CreateStudent.CreateStudentDTO;
import com.smitiv.test.Service.CreateStudent.CreateStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentServiceImpl implements UpdateStudentService{


    @Autowired
    StudentRepository studentRepository;

    @Override
    public UpdateStudentResponse execute(UpdateStudentDTO updateStudentDTO) {
        UpdateStudentResponse response = null;
        Student student = new Student();
        try {
            //validate request
            validateRequest(updateStudentDTO);
            student = studentRepository.findByStudent(updateStudentDTO.getId());

            //update student info
            //save student info
            student.setName(updateStudentDTO.getName());
            student.setAge(updateStudentDTO.getAge());
            student.setGender(updateStudentDTO.getGender());
            student.setRollNumber(updateStudentDTO.getRollNumber());
            student.setPhoneNumber(updateStudentDTO.getPhoneNumber());
            student.setAddress(updateStudentDTO.getAddress());
            studentRepository.save(student);

            //set success response
            response = new UpdateStudentResponse();
            response.SUCCESSFUL = true;
            response.setId(student.getId());
            response.setMessage("Successfully updated the  student info");

        }catch (Exception e){
            //set failure response
            response = new UpdateStudentResponse();
            response.SUCCESSFUL = false;
            response.setMessage("Failure" + ":" + e.getMessage());
        }
        return response;
    }

    private void validateRequest(UpdateStudentDTO updateStudentDTO) throws Exception {
        if (updateStudentDTO.getId() == null) {
            throw new Exception("ID should not be empty or null");
        }
        if (updateStudentDTO.getName() == null || updateStudentDTO.getName().isEmpty()) {
            throw new Exception("Name should not be empty or null");
        }
        if (updateStudentDTO.getAge() == null) {
            throw new Exception("Age should not be empty or null");
        }
        if (updateStudentDTO.getGender() == null || updateStudentDTO.getGender().isEmpty()) {
            throw new Exception("Gender should not be empty or null");
        }
        if (updateStudentDTO.getRollNumber() == null) {
            throw new Exception("RollNumber should not be empty or null");
        }
        if (updateStudentDTO.getPhoneNumber() == null || updateStudentDTO.getPhoneNumber().isEmpty()) {
            throw new Exception("PhoneNumber should not be empty or null");
        }
        Long studentId = studentRepository.findByStudentId(updateStudentDTO.getId());
        if(studentId == null){
            throw new Exception("Student with given ID does not exist");
        }
    }
}
