package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.security.JwtProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class UserJWTControllerBuilder {
    private JwtProvider jwtProvider;
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserJWTControllerBuilder setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
        return this;
    }

    public UserJWTControllerBuilder setAuthenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        return this;
    }

    public UserJWTController createUserJWTController() {
        return new UserJWTController(jwtProvider, authenticationManagerBuilder);
    }
}