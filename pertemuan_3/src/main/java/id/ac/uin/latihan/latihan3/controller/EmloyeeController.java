package id.ac.uin.latihan.latihan3.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import id.ac.uin.latihan.latihan3.employee.Employee;
import id.ac.uin.latihan.latihan3.service.EmployeeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/employees")
public class EmloyeeController {
  private final EmployeeService employeeService;

  @GetMapping
  public String showEmployeeForm(Model model) {
    model.addAttribute("employee", new Employee());

    return "employee/createEmployeeForm";
  }

  @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })

  public String saveEmployee(@ModelAttribute Employee employee) {
    employeeService.save(employee);

    return "employee/success";
  }

  @PostMapping(path = "/requestpart", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })

  public ResponseEntity<Object> saveEmpployee(@RequestPart Employee employee, MultipartFile document) {
    employee.setDocument(document);
    employeeService.save(employee);

    return ResponseEntity.ok().build();
  }

  
  @PostMapping(path = "requestparam", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })

  public ResponseEntity<Object> saveEmployeEntity(@RequestParam String name, @RequestPart MultipartFile document) {
    Employee employee = new Employee(name, document);
    employeeService.save(employee);

    return ResponseEntity.ok().build();
  }
}
