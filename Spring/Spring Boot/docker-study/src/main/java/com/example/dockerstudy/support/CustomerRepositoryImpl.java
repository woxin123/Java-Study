package com.example.dockerstudy.support;

import com.example.dockerstudy.support.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.example.dockerstudy.specs.CustomerSpecs.byAuto;

/**
 * @author mengchen
 * @time 18-9-27 下午3:00
 */
public class CustomerRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomerRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager, example), pageable);
    }
}
