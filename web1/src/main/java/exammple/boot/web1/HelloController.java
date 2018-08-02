package exammple.boot.web1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    public HelloController() {
        System.out.println("Hello Controller");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam(name = "name", required = true) String name,
                         @RequestParam(name = "age", required = false, defaultValue = "0") int age) {
        return "hello" +  name+" : "+age;
    }

    @GetMapping("/hello3")
    public String hello3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "hello "+name+age;
    }


}
