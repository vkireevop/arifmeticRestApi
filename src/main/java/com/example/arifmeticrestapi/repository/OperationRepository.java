package com.example.arifmeticrestapi.repository;

import com.example.arifmeticrestapi.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
