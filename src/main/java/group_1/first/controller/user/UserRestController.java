package group_1.first.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import group_1.first.method.Methods;
import group_1.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/api")
public class UserRestController {

    @Autowired
    private UserService userService;
    @GetMapping("send")
    public ResponseEntity send(@RequestParam("s") String s) throws JsonProcessingException {
        return ResponseEntity.ok(Methods.generate(s));
    }

    @GetMapping("tasks")
    public ResponseEntity tasks(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return ResponseEntity.ok(userService.findAllTaskByUsername(authentication.getName()));
        return ResponseEntity.ok(userService.getAllTaskSpecial(authentication.getName()));
    }


}
