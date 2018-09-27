package com.example.dockerstudy.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author mengchen
 * @time 18-9-27 下午2:57
 */
@NoRepositoryBean
public interface CustomerRepository<T, ID extends Serializable> extends JpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {
    Page<T> findByAuto(T example, Pageable pageable);
}
