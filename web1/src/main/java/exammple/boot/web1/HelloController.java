package exammple.boot.web1;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hello4")
    public String hello4(@ModelAttribute HelloDTO helloDTO) {
        return "hello "+ helloDTO.getName() + helloDTO.getAge();
    }

    @PostMapping(path = "hello5")
    public String hello5() {
        return "hello5";
    }

    @PostMapping("/hello6")
    public String hello6(@RequestParam(name = "name", required = true) String name,
                         @RequestParam(name = "age", required = false, defaultValue = "0") int age) {
        return "hello" +  name+" : "+age;
    }

    @PostMapping("/hello7")
    public String hello7(@RequestBody HelloDTO helloDTO) {
        return "hello " + helloDTO.getName() + helloDTO.getAge();
    }

    @GetMapping("/hello8")
    public HelloDTO hello8() {
        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setName("oh");
        helloDTO.setAge(30);

        return helloDTO;
    }
}

