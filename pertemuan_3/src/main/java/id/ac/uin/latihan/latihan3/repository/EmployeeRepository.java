package id.ac.uin.latihan.latihan3.repository;

import org.springframework.stereotype.Repository;

import id.ac.uin.latihan.latihan3.employee.Employee;

@Repository
public interface EmployeeRepository {
  void saveEmployee(Employee employee);
}
