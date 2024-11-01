package io.github.leandrotominay.domain.repository;

import io.github.leandrotominay.domain.model.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {


}
