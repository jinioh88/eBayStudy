package exammple.boot.web1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class boardAPIController {
    @GetMapping public String boards() {
        return "boards";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable(name = "id")int id) {
        return "board_"+ id;
    }
}
