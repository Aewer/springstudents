package kz.miros.springstudents.controller;

import kz.miros.springstudents.model.Student;
import kz.miros.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    public Student findStudentByEmail(@PathVariable String email) {
        return studentService.findStudentByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }
}
