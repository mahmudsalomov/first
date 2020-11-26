package group_1.first.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRest {
    @GetMapping("getrole")
    public ResponseEntity getRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getAuthorities());
//        System.out.println(authentication.getPrincipal());
//        System.out.println(authentication.getDetails());
//        System.out.println(authentication.getCredentials());
//        System.out.println(authentication.getName());
        return ResponseEntity.ok(authentication.getAuthorities().toArray()[0].toString());
    }

    @GetMapping("getusername")
    public ResponseEntity getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication.getName());
    }
}
