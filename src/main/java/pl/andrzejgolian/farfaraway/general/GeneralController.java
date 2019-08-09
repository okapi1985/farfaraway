package pl.andrzejgolian.farfaraway.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String home(){

        return "/main/main";
    }

    @RequestMapping("/secret")
    public String secret(){

        return "/main/secret";
    }
}
