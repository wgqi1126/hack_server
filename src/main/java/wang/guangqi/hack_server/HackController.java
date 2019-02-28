package wang.guangqi.hack_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HackController {
    @RequestMapping("/imghp")
    public String imghp() {
        return "hacked";
    }
}
