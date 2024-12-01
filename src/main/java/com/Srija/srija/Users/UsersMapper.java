package com.Srija.srija.Users;

import org.springframework.stereotype.Service;

@Service
public class UsersMapper {
    public UsersDto userresponse(Users user){
        return new UsersDto(user.getUsername(),user.getEmail());
    }

    public UsersDto tofindusers(Users user){
        return new UsersDto(user.getUsername(),user.getEmail());
    }
}
