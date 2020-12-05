package group_1.first.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user/user";
    }

    @GetMapping("/about")
    public String about(){
        return "reklom/koproq_bilish";
    }

    @GetMapping("/qani_ketdik")
    public String qani_ketdik(){
        return "reklom/qani_ketdik";
    }

    @GetMapping("/test")
    public String test(){
        return "api_test";
    }

}
