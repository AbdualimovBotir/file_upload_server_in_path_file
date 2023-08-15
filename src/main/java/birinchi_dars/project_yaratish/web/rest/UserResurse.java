package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.Users;
import birinchi_dars.project_yaratish.service.UserServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResurse {
    private final UserServise userServise;
    public UserResurse(UserServise userServise){
        this.userServise=userServise;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody Users users){
        if(userServise.existUserLogin(users.getLogin())){
            return new ResponseEntity("Bu login mavjud", HttpStatus.BAD_REQUEST);
        }
        if(checkPasswordLength(users.getPassword())){
            return new ResponseEntity("Password uzunligi 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        Users result=userServise.save(users);
        return ResponseEntity.ok(result);
    }
    private Boolean checkPasswordLength(String password){
        return password.length()<=4;
    }
}
