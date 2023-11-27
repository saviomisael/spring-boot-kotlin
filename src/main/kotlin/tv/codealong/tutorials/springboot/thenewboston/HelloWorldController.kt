package tv.codealong.tutorials.springboot.thenewboston

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tv.codealong.tutorials.springboot.thenewboston.model.Employee
import tv.codealong.tutorials.springboot.thenewboston.validator.EmployeeValidator

@RestController
@RequestMapping("api/hello")
class HelloWorldController @Autowired constructor(val employeeValidator: EmployeeValidator) {
    @GetMapping
    fun helloWorld(): String = "Hello, this is a REST endpoint!"

    @PostMapping("employees")
    fun validateEmployee(@Valid @RequestBody employee: Employee): ResponseEntity<String> {
        return ResponseEntity.ok("Employee created successfully")
    }
}