package projects.dex.collectman.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/demo-test")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> testDemo() {
        return ResponseEntity.ok("Secured because this api path not permited without authentification! ");
    }

}
