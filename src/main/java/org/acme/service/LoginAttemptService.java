package org.acme.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.LoginAttempt;
import org.acme.model.RegisteredUser;

import java.util.UUID;

@ApplicationScoped
public class LoginAttemptService {




    @Transactional
    public String login(RegisteredUser user){

        if(user == null) {
            return "{\"message\":\"Registered email param with correct form expected.\"}";
        }

        String token = generateAndSetTokenFor(user.getEmail());
        return "{\"message\":\"Login link sent to " + user.getEmail() + ".\"}";


    }

    @Transactional
    public String requestAccess(String token){
        System.out.println("tkn " + token);


        LoginAttempt.deleteById(token);
        return "{\"message\":\"Access granted.\"}";
    }


    public static String generateAndSetTokenFor(String email){
        String token = UUID.randomUUID().toString();

        LoginAttempt attempt = new LoginAttempt(email, token);
        attempt.persist();
        System.out.println("Generated login link: http://localhost:8080/requestaccess?token=" + token);
        return token;
    }










}
