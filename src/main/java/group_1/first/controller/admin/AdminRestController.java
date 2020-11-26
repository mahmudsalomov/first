package group_1.first.controller.admin;

import group_1.first.model.UserCourse;
import group_1.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/api")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("one")
    public ResponseEntity getOne(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.getOne(id));
    }

    @PostMapping("add")
    public ResponseEntity add(@RequestBody UserCourse userCourse){
        if (!userService.existsByUsername(userCourse.getUsername())){
            userCourse.setRole("USER");
            userCourse.setPassword(passwordEncoder.encode(userCourse.getPassword()));
            return ResponseEntity.ok(userService.save(userCourse));
        }
        else return ResponseEntity.ok("Error");
    }

    @PostMapping("edit")
    public ResponseEntity edit(@RequestBody UserCourse userCourse){
        if (userCourse.getUsername().equals("admin")){
            userCourse.setRole("ADMIN");
        } else userCourse.setRole("USER");
            userCourse.setPassword(passwordEncoder.encode(userCourse.getPassword()));
            return ResponseEntity.ok(userService.save(userCourse));


    }

}
