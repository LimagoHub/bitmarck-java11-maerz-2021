package de.bitmarck.mathserver;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

	@GetMapping(path = "/add")
	public ResponseEntity<Double> add(@RequestParam double a, @RequestParam double b){
		return ResponseEntity.ok(a + b);
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> addPost(@RequestBody Params params){
		return ResponseEntity.ok(params.getA() + params.getB());
	}
	

}
