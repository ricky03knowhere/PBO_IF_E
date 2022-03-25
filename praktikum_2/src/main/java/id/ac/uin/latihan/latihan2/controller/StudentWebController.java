package id.ac.uin.latihan.latihan2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import id.ac.uin.latihan.latihan2.entity.Student;
import id.ac.uin.latihan.latihan2.service.StudentService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentWebController {
  private StudentService studentService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("student", studentService.getAllStudents());
    return "index";
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("student", new Student());
    return "formStudent";
  }

  @PostMapping("/create")
  public String addStudent(Model model, Student student) {
    model.addAttribute("student", studentService.save(student));
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String index(@PathVariable Long id, Model model) {
    model.addAttribute("student", studentService.findById(id));
    return "formStudent";
  }

  @GetMapping("/delete/{id}")
  public String index(@PathVariable Long id) {
    studentService.deleteById(id);
    return "redirect:/";
  }
}
