package test.org.springdoc.api.app14;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class HelloController {

    @GetMapping("/persons")
    public void persons(@Valid @NotBlank String name) {

    }

    @GetMapping("/test")
    public HttpEntity<String> demo2() {
        return null;
    }
}
