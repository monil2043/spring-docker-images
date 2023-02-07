package lecture.springboot_simple;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @GetMapping(value = { "/", "/datetime" })
    public ResponseEntity<String> getDateTime() {
        String res = "Server Time: " + new Date().toString();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> greetUser(@PathVariable String name) {
        String res = "Hello 7thFeb try21, " + name;
        return ResponseEntity.ok(res);
    }
	
	@GetMapping("/covid")
    public JSONObject getHelloClient1() {
        final String uri = "https://api.covid19api.com/";

        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(uri, JSONObject.class);

        System.out.println(result);
        
        return result;
    }
	
	@GetMapping("/employees")
    public JSONObject getHelloClient2() {
        final String uri = "https://dummy.restapiexample.com/api/v1/employees";

        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(uri, JSONObject.class);

        System.out.println(result);
        
        return result;
    }
	
	@GetMapping("/employees/{id}")
    public JSONObject getHelloClient(@PathVariable Integer id) {
        final String uri = "https://dummy.restapiexample.com/api/v1/employee/" + id ;

        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(uri, JSONObject.class);

        System.out.println(result);
        
        return result;
    }

    @GetMapping("/ascii")
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
