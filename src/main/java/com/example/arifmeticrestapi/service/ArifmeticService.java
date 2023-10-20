package com.example.arifmeticrestapi.service;

public interface ArifmeticService {
    double summary(double[] numbers,boolean flag);
    double multiply(double[] numbers,boolean flag);
    double custom(double[] numbers);
    double divide(double dividend, double divisor);
}
