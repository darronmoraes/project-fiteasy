package com.developerjugad.fiteasy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developerjugad.fiteasy.db.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

}