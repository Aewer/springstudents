package kz.miros.springstudents.service.impl;

import kz.miros.springstudents.model.Student;
import kz.miros.springstudents.repository.InMemoryStudentDAO;
import kz.miros.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentDAO repository;

    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return repository.findStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}
