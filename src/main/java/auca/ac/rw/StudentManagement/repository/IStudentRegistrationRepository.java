package auca.ac.rw.StudentManagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.StudentManagement.model.Semester;
import auca.ac.rw.StudentManagement.model.Student;
import auca.ac.rw.StudentManagement.model.StudentRegistration;

@Repository
public interface IStudentRegistrationRepository extends JpaRepository<StudentRegistration, UUID> {

    StudentRegistration findByStudentAndSemester(Student student, Semester semester);
}
