package kz.miros.springstudents.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.miros.springstudents.model.Student;
import kz.miros.springstudents.service.StudentService;
import kz.miros.springstudents.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Получить список всех студентов")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/admin")
    @Operation(summary = "Сохранить запись о студенте. Доступно только пользователям с ролью ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    @Operation(summary = "Найти запись о студенте с помощью электронной почты")
    public Student findStudentByEmail(@PathVariable String email) {
        return studentService.findStudentByEmail(email);
    }

    @PutMapping("/admin")
    @Operation(summary = "Обновить запись о студенте. Доступно только пользователям с ролью ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/admin/{email}")
    @Operation(summary = "Удалить запись о студенте. Доступно только пользователям с ролью ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Получить роль ADMIN")
    public void getAdmin() {
        userService.getAdmin();
    }
}
