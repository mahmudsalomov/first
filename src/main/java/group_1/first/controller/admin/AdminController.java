package group_1.first.controller.admin;

import group_1.first.model.PrivateTask;
import group_1.first.service.PrivateTaskService;
import group_1.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;
    private final PrivateTaskService privateTaskService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminController(UserService userService, PrivateTaskService privateTaskService) {
        this.userService = userService;
        this.privateTaskService = privateTaskService;
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





    /*Maxsus Tasklar uchun*/

    @GetMapping("task/all")
    public String allPTask(Model model){
        model.addAttribute("tasks",privateTaskService.getAll());
        return "admin/p_task/list";
    }

    @GetMapping("task/add")
    public String addPTask(){
        return "admin/p_task/add";
    }

    @GetMapping("task/edit")
    public String editPTask(){
        return "admin/p_task/edit";
    }

}
