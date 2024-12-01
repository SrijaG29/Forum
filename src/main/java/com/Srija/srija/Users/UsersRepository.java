package com.Srija.srija.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
    Users findByEmail(String email);
    Users findByUserid(Integer id);
}
