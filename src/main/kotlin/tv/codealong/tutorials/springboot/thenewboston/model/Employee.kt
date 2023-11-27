package tv.codealong.tutorials.springboot.thenewboston.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import kotlin.math.min

data class Employee(
        @field:Min(1, message = "Id must be a positive number.") val id: Int,
        @field:Length(min = 3, max = 80, message = "Name must have length between 3 and 80.") val name: String,
        @field:NotBlank(message = "Email invalid.") @field:Email(message = "Email pattern invalid.") val email: String) {
}