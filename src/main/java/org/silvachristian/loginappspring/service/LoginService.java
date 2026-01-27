package org.silvachristian.loginappspring.service;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.repository.LoginRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private static LoginRepository loginrepository;

    public LoginService (LoginRepository loginRepository){
        LoginService.loginrepository = loginRepository;
    }

    public static List<User> create(User user){
        loginrepository.save(user);
        return list();
    }

    public static List<User> list(){
        Sort sort = Sort.by("username");

        return loginrepository.findAll(sort);
    }

    public static List<User> update(User user){
        loginrepository.save(user);
        return list();
    }

    public static List<User> delete(Long Id){
        loginrepository.deleteById(Id);
        return list();
    }
}
