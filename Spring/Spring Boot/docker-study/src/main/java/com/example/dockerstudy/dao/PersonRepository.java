package com.example.dockerstudy.dao;

import com.example.dockerstudy.domain.Person;
import com.example.dockerstudy.support.CustomerRepository;
import com.example.dockerstudy.support.CustomerRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author mengchen
 * @time 18-9-27 上午10:51
 */
public interface PersonRepository extends CustomerRepository<Person, Long> {

    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name,
                                   @Param("address") String address);

    /**
     * 请注意这里使用的是实体类中的@NamedQuery注解
     * @param name
     * @param address
     * @return
     */
    Person withNameAndAddressNameQuery(String name, String address);
}
