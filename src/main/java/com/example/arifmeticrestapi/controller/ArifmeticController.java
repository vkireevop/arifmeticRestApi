package com.example.arifmeticrestapi.controller;

import com.example.arifmeticrestapi.service.ArifmeticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/calculator")
public class ArifmeticController {
    private final ArifmeticService arifmeticService;

    public ArifmeticController(ArifmeticService arifmeticService) {
        this.arifmeticService = arifmeticService;
    }
    @GetMapping("/summary")
    public ResponseEntity<?> summary (@RequestParam double[] numbers) {
        return new ResponseEntity<>(arifmeticService.summary(numbers,true), HttpStatus.OK);
    }
    @GetMapping("/multiply")
    public ResponseEntity<?> multiply (@RequestParam double[] numbers) {
        return new ResponseEntity<>(arifmeticService.multiply(numbers,true), HttpStatus.OK);
    }
    @GetMapping("/custom")
    public ResponseEntity<?> custom (@RequestParam double[] numbers) {
        return new ResponseEntity<>(arifmeticService.custom(numbers),HttpStatus.OK);
    }
    @GetMapping("/divide")
    public ResponseEntity<?> divide (@RequestParam double dividend,@RequestParam double divisor )
    {
        if (divisor == 0)
        {
            return ResponseEntity.badRequest().body("Нельзя поделить на ноль");
        }
        return new ResponseEntity<>(arifmeticService.divide(dividend,divisor),HttpStatus.OK);
    }
    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleIOException() {
        return ResponseEntity.badRequest().body("Некорректные данные");
    }
}
