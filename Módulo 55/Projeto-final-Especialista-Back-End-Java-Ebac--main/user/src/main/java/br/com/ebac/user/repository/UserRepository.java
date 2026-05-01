package br.com.ebac.user.repository;

import br.com.ebac.user.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
