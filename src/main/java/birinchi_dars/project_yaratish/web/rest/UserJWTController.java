package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.security.JwtProvider;
import birinchi_dars.project_yaratish.web.rest.vm.LoginVM;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserJWTController {
    private final JwtProvider jwtProvider;

    private  final AuthenticationManagerBuilder authenticationManagerBuilder;
    public UserJWTController(JwtProvider jwtProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtProvider = jwtProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity authorize(@Validated @RequestBody LoginVM loginVM){
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginVM.getLogin(),loginVM.getPassword());
        Authentication authentication;
        authentication = (Authentication) authenticationManagerBuilder.getObject().authenticate(authenticationToken).getAuthorities();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String Jwt=jwtProvider.createToken(loginVM.getLogin(),authentication);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization","Bearer "+Jwt);
        return new ResponseEntity(new JWTToken(Jwt),headers, HttpStatus.OK);
    }


    static class JWTToken{
        private String idtoken;

        public JWTToken(String token) {
            this.idtoken = token;
        }

        public String getIdtoken() {
            return idtoken;
        }

        public void setIdtoken(String idtoken) {
            this.idtoken = idtoken;
        }
    }
}
