package com.example.jpaexample;

import com.example.jpaexample.entity.*;
import com.example.jpaexample.repository.GroupRepository;
import com.example.jpaexample.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JpaExampleApplicationTests {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void initData() {
    }

    @Test
    void test1() {
        User user1 = User.builder()
                .name("현태")
                .group(Group.builder()
                        .groupName("연구소")
                        .build()
                )
                .build();
        userRepository.save(user1);
    }
}
