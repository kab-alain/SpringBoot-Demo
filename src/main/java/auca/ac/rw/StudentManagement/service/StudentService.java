package auca.ac.rw.StudentManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.StudentManagement.model.Student;
import auca.ac.rw.StudentManagement.repository.IStudentRepository;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;

    public String saveStudent(Student student) {

        Optional<Student> checkStudent = studentRepository.findByFirstNameAndLastName(student.getFirstName(),
                student.getLastName());

        if (checkStudent.isPresent()) {
            return "student exists";
        } else {
            studentRepository.save(student);
            return "student saved successfully";
        }

    }

    public Student getStudentByFirstName(String firstName) {
        Optional<Student> student = studentRepository.findByFirstName(firstName);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

}
