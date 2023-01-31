package lecture.springboot_simple;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class SimpleController {

    @GetMapping(value = { "/", "/datetime" })
    public ResponseEntity<String> getDateTime() {
        String res = "Server Time: " + new Date().toString();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> greetUser(@PathVariable String name) {
        String res = "Hello 30JanDemo try3 with docker, " + name;
        return ResponseEntity.ok(res);
    }

    @GetMapping("/aston")
    public ResponseEntity<String> randomAscii() {
        return ResponseEntity.ok(generateRandomAscii(10000));
    }

    public String generateRandomAscii(int numOfChars) {
//        String availChars = "_-/\\|(),.<>;:'=+!@#$%^&*";
        String availChars = "_-/\\|()";
        StringBuilder bigString = new StringBuilder();

        for (int i = 0; i < numOfChars; i++) {
            int randomIndex = (int) (Math.random() * availChars.length());
            bigString.append(availChars.charAt(randomIndex));
        }

        return bigString.toString();
    }
}
