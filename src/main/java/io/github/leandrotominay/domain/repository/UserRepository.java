package io.github.leandrotominay.domain.repository;

import io.github.leandrotominay.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
//persist panache


}
