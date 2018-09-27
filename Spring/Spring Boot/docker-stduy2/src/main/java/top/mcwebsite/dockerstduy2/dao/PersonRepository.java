package top.mcwebsite.dockerstduy2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import top.mcwebsite.dockerstduy2.domain.Person;

/**
 * @author mengchen
 * @time 18-9-27 下午4:05
 */
//@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartWith")
    Person findByNameStartingWith(String name);
}
