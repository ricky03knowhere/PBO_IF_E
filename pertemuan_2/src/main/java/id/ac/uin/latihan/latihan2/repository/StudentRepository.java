package id.ac.uin.latihan.latihan2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.uin.latihan.latihan2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  // Query Method
  Optional<Student> findByEmail(String email);
}
