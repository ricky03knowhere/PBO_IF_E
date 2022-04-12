package id.ac.uin.latihan.latihan1;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")

public class IndexController {

  @GetMapping("hello")

  public String Hello(@RequestParam String name) {
    return "Hello World...<br>Your name is " + name + "<br>Date : " + LocalDate.now();
  }
}
