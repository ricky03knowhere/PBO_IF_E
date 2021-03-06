package id.ac.uin.latihan.latihan2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "First name is required")
  @Column(nullable = false, name = "first_name")
  private String firstName;

  @NotEmpty(message = "Last name is required")
  @Column(nullable = false, name = "last_name")
  private String lastName;

  @NotEmpty(message = "Email name is required")
  @Column(nullable = false, name = "email", unique = true)
  private String email;

  @NotEmpty(message = "Phone Number is required")
  @Column(nullable = false, name = "phone", unique = true)
  private String phone;

  @NotEmpty(message = "Jurusan is required")
  @Column(nullable = false, name = "jurusan", unique = true)
  private String jurusan;
}
