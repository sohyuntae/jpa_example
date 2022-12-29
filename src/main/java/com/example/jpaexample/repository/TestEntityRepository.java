package com.example.jpaexample.repository;

import com.example.jpaexample.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}
