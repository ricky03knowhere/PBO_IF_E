package id.ac.uin.latihan.latihan2.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.uin.latihan.latihan2.entity.Student;
import id.ac.uin.latihan.latihan2.exception.StudentNotFoundException;
import id.ac.uin.latihan.latihan2.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  private final StudentService studentservice;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentservice = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentservice.getAllStudents();
  }

  @GetMapping(value = "/{id}")
  public Student getStudentById(@PathVariable("id") @Min(1) Long id) {
    Student std = studentservice.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is not found!"));

    return std;
  }

  @PostMapping
  public Student addStudent(@Valid @RequestBody Student std) {
    return studentservice.save(std);
  }

  @PutMapping(value = "/{id}")
  public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd) {

    Student student = studentservice.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is not found!"));

    student.setFirstName(newStd.getFirstName());
    student.setLastName(newStd.getLastName());
    student.setEmail(newStd.getEmail());
    student.setPhone(newStd.getPhone());

    return studentservice.save(student);
  }

  @DeleteMapping(value = "/{id}")

  public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
    Student std = studentservice.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is not found!"));
    studentservice.deleteById(std.getId());

    return "Student with ID " + id + " is deleted";
  }
}
