package com.example.jpaexample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="test2Table")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Test2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
