package com.umpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UmpaApplication

fun main(args: Array<String>) {
	runApplication<UmpaApplication>(*args)
}
