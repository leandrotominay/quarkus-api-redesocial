package io.github.leandrotominay.domain.model;

import jakarta.persistence.*;
import lombok.Data;




@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    private Integer age;

}
