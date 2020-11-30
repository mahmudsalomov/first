package group_1.first.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import group_1.first.method.Methods;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/api")
public class UserRestController {

    @GetMapping("send")
    public ResponseEntity send(@RequestParam("s") String s) throws JsonProcessingException {
        return ResponseEntity.ok(Methods.generate(s));
    }


}
