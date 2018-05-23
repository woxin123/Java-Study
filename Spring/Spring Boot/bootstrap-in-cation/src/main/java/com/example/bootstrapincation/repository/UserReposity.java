package com.example.bootstrapincation.repository;


import com.example.bootstrapincation.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserReposity extends CrudRepository<User, Long> {

}
