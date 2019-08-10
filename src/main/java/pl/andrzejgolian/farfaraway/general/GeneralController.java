package pl.andrzejgolian.farfaraway.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/farfaraway")
    public String home(){

        return "/main/main";
    }

    @RequestMapping("/admin")
    public String admin(){

        return "/main/admin";
    }
}
