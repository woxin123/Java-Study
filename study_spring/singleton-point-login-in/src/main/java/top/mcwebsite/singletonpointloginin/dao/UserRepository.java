package top.mcwebsite.singletonpointloginin.dao;


import org.springframework.data.repository.CrudRepository;
import top.mcwebsite.singletonpointloginin.model.User;


/**
 * @author mengchen
 * @time 18-11-17 下午5:05
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);

}
