package com.smitiv.test.Controller;

import com.smitiv.test.Service.CreateStudent.CreateStudentDTO;
import com.smitiv.test.Service.CreateStudent.CreateStudentResponse;
import com.smitiv.test.Service.CreateStudent.CreateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    CreateStudentService createStudentService;

    @PostMapping(value = "/createStudent", produces = "application/json")
    public ResponseEntity createStudent(@RequestBody CreateStudentDTO createStudentDTO) {
        CreateStudentResponse response = null;
        try {
            response = createStudentService.execute(createStudentDTO);
        } catch (Exception e) {
            response.SUCCESSFUL = false;
            response.setMessage("Failure:");
        }
        if (response.SUCCESSFUL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(response.getMessage()).body(response);
        }
    }
}
