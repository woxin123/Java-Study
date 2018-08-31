package top.mcwebsite.webflux2.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import top.mcwebsite.webflux2.domain.User;

/**
 * @author mengchen
 * @time 18-8-24 下午3:19
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<User> findByAgeBetween(int start, int end);

    @Query("{'age': {'$gte': 20, '$lte':30}}")
    Flux<User> oldUser();
}
