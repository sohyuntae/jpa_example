package com.example.jpaexample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="userTable")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*
    * @ManyToOne 관련 어노테이션 사용시, 세부 옵션 체크
    * cascade : 해당 옵션에 대한 체크 필요.
    * @JoinColumn 관련 어노테이션 사용시, 세부 옵션 체크
    * insertable, updatable 읽기 전용 옵션
    * @GeneratedValue 위의 해당 어노테이션이 존재할떄와 존재하지 않을때의 차이 여부 체크.
    * */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;
}
