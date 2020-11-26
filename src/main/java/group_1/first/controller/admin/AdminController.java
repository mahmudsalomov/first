package group_1.first.controller.admin;

import group_1.first.model.UserCourse;
import group_1.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public String all(Model model){
        model.addAttribute("users",userService.getAllSort());
        return "admin/list_user";
    }

    @GetMapping("add")
    public String add(){
        return "admin/add_user";
    }

    @GetMapping("edit")
    public String edit(){
        return "admin/edit_user";
    }

}
