package com.smitiv.test.Service.GetStudentDetailById;

import com.smitiv.test.Domain.Student;
import com.smitiv.test.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStudentByIdServiceImpl implements GetStudentByIdService{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public GetStudentByIdResponse execute(Long id) {
        GetStudentByIdResponse response = null;
        try {
            //validate id exist or not
            validateRequest(id);
            Student student = studentRepository.findByStudent(id);
            if (student != null){
                response = new GetStudentByIdResponse();
                response.setStudent(student);
                response.SUCCESSFUL = true;
                response.setMessage("Success :" );
            }
        }catch (Exception e){
            //set failure response
            response = new GetStudentByIdResponse();
            response.SUCCESSFUL = false;
            response.setMessage("Failure" + ":" + e.getMessage());
        }
        return response;
    }

    private void validateRequest(Long id) throws Exception {
        Long studentId = studentRepository.findByStudentId(id);
        if(studentId == null){
            throw new Exception("Student with given id does not exist");
        }
    }
}
