package com.service.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.books.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
