package com.Srija.srija.Users;

import com.Srija.srija.Answers.Answers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private UsersService usersService;
    private UsersRepository usersRepository;

    public UsersController(UsersService usersService,UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @PostMapping("/usercreate")
    public String createuser(
            @RequestBody UsersrequestDto users
    ){
        Users users1 = new Users();
        users1.setUsername(users.getUsername());
        users1.setEmail(users.getEmail());
        users1.setPassword(users.getPassword());
        usersRepository.save(users1);
//        return usersService.createuser(users);
        return "User created";
    }



    //    Finding all users
    @GetMapping("/allusers")
    public List<UsersDto> findall(){

        return usersService.findall();
    }


    //    Finding by username
    @GetMapping("/usersdetails/username/{username}")
    public UsersresponseDto findbyusername(
            @PathVariable("username") String username
    ){
        return usersService.findbyusername(username);

    }



}
