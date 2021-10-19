package org.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ConfigServlet {

    @RequestMapping("/homePage") //если вводим просто слэш то возвращается это JSP
    public String showHomePage() {
        return "homePage";
    }

    @RequestMapping("/") //если вводим просто слэш то возвращается это JSP
    public String showFirstView() {
        return "login";
    }
}
