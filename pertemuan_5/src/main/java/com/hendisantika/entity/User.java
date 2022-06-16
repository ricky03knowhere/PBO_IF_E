package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-adminlte3-template
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/15/22
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Username is required")
    @Column(nullable = false, name = "username", unique = true)
    private String username;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    private String password;
}
