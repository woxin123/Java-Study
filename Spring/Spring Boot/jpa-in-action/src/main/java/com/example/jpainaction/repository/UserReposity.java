package com.example.jpainaction.repository;


import com.example.jpainaction.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserReposity extends CrudRepository<User, Long> {

}
