package com.example.arifmeticrestapi.service;

import com.example.arifmeticrestapi.model.Operation;
import com.example.arifmeticrestapi.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArifmeticServiceImpl implements ArifmeticService{

    private final OperationRepository operationRepository;

    public ArifmeticServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public double summary(double[] numbers,boolean flag) {
        double result =  Arrays.stream(numbers).sum();
        if (flag) {
            save(Arrays.stream(numbers)
                    .boxed()
                    .collect(Collectors.toList()), "summary", result);
        }
        return result;
    }

    @Override
    public double multiply(double[] numbers,boolean flag) {
        double result =  Arrays.stream(numbers).reduce(1,(a,b)->a*b);
        if (flag) {
            save(Arrays.stream(numbers)
                    .boxed()
                    .collect(Collectors.toList()), "multiply", result);
        }
        return result;
    }

    @Override
    public double custom(double[] numbers) {
        double multiplicationResult = multiply(new double[]{numbers[0], numbers[1]},false);
        double result = summary(new double[]{multiplicationResult,numbers[2]},false);
        save(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()),"custom",result);
        return result;
    }
    @Override
    public double divide(double dividend, double divisor){
        List<Double> parameters = new ArrayList<>();
        parameters.add(dividend);
        parameters.add(divisor);
        save(parameters,"divide",dividend/divisor);
        return dividend / divisor;
    }
    private void save(List<Double> parameters, String type, Double result){
            Operation operation = new Operation();
            operation.setType(type);
            operation.setResult(result);
            operation.setParameters(parameters);
            operationRepository.save(operation);

    }

}
