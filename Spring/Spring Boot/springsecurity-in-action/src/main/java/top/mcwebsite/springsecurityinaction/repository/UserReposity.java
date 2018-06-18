package top.mcwebsite.springsecurityinaction.repository;

import org.springframework.data.repository.CrudRepository;
import top.mcwebsite.springsecurityinaction.domain.User;

public interface UserReposity extends CrudRepository<User, Long> {

}
