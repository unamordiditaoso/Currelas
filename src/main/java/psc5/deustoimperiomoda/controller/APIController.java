package psc5.deustoimperiomoda.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController

public class APIController {
    public APIController() {
        
    }
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
    
}
