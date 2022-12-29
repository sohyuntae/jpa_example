package com.example.jpaexample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="groupTable")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
}
