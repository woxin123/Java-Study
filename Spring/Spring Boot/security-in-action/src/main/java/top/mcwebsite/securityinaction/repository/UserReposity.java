package top.mcwebsite.securityinaction.repository;

import org.springframework.data.repository.CrudRepository;
import top.mcwebsite.securityinaction.domain.User;

public interface UserReposity extends CrudRepository<User, Long> {

}
