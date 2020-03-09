package com.yo1000.demo.maven_npm_integration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime
import java.util.*

@SpringBootApplication
class DemoMavenNpmIntegrationApplication

fun main(args: Array<String>) {
	runApplication<DemoMavenNpmIntegrationApplication>(*args)
}

@Controller
@RequestMapping("/")
class DemoController {
	@GetMapping
	fun getIndex(model: Model): String {
		model.addAttribute("uuid", UUID.randomUUID().toString())
		model.addAttribute("now", LocalDateTime.now())

		var f0 = 0
		var f1 = 1
		var f2: Int
		val fib = mutableListOf<Int>()
		(0..20).forEach { _ ->
			fib += f0
			f2 = f0 + f1
			f0 = f1
			f1 = f2
		}
		model.addAttribute("fib", fib)

		return "index"
	}
}
