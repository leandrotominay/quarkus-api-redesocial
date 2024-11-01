package io.github.leandrotominay.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name= "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_text")
    private String text;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    // Relacionamento (FK de outra tabela)
    @ManyToOne // Muitas postagens para um usuário
    @JoinColumn(name = "user_id" )
    @JsonbTransient
    private User user;
}
