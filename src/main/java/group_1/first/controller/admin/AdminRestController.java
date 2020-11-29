package group_1.first.controller.admin;

import group_1.first.model.PrivateTask;
import group_1.first.model.UserCourse;
import group_1.first.service.PrivateTaskService;
import group_1.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/api")
public class AdminRestController {

    private final UserService userService;
    private final PrivateTaskService privateTaskService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminRestController(UserService userService, PrivateTaskService privateTaskService) {
        this.userService = userService;
        this.privateTaskService = privateTaskService;
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

    @PutMapping("edit")
    public ResponseEntity edit(@RequestBody UserCourse userCourse){
        if (userCourse.getUsername().equals("admin")){
            userCourse.setRole("ADMIN");
        } else userCourse.setRole("USER");
            userCourse.setPassword(passwordEncoder.encode(userCourse.getPassword()));
            return ResponseEntity.ok(userService.save(userCourse));
    }









    @GetMapping("task/all")
    public ResponseEntity allPrivateTask(){
        return ResponseEntity.ok(privateTaskService.getAll());
    }

    @GetMapping("task/one")
    public ResponseEntity onePrivateTask(@RequestParam("id") Long id){
        return ResponseEntity.ok(privateTaskService.getOne(id));
    }

    @PostMapping("task/add")
    public ResponseEntity addPrivateTask(@RequestBody PrivateTask privateTask){
        return ResponseEntity.ok(privateTaskService.save(privateTask));
    }

    @PutMapping("task/edit")
    public ResponseEntity editPrivateTask(@RequestBody PrivateTask privateTask){
        return ResponseEntity.ok(privateTaskService.save(privateTask));
    }




}
