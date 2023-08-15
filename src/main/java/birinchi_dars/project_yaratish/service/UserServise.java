package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.UserRepository;
import birinchi_dars.project_yaratish.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServise {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder; // Change this


    @Autowired
    public UserServise(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; // And this
    }

    public Users save(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public boolean existUserLogin(String login){
        return userRepository.existsByLogin(login);
    }

}
