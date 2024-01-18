package hello.shopservice.main.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @GetMapping()
    public String userPage() {
        return "ok";

    }

    @GetMapping("/join")
    public String joinUser(){

        return "basic/joinForm";

    }
    @GetMapping("/login")
    public String login(){

        return "basic/joinForm";

    }



}
