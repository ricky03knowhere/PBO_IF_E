package id.ac.uin.latihan.latihan2.service;

import java.util.List;
import java.util.Optional;

import id.ac.uin.latihan.latihan2.entity.Student;

public interface StudentService {
  List<Student> getAllStudents();

  Optional<Student> findById(Long id);

  Optional<Student> findByEmail(String email);

  Student save(Student std);

  void deleteById(Long id);
}
