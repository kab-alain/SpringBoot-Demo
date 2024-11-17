package auca.ac.rw.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.StudentManagement.model.Student;
import auca.ac.rw.StudentManagement.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        String saveStudent = studentService.saveStudent(student);
        if (saveStudent.equalsIgnoreCase("student exists")) {
            return new ResponseEntity<>("student exists", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>("student saved", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentByFirstName(@RequestParam String firstName) {
        Student student = studentService.getStudentByFirstName(firstName);
        if (student == null) {
            return new ResponseEntity<>("No student found with the given first name", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
}
