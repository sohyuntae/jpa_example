package com.example.jpaexample;

import com.example.jpaexample.entity.Test2Entity;
import com.example.jpaexample.entity.TestEntity;
import com.example.jpaexample.repository.Test2EntityRepository;
import com.example.jpaexample.repository.TestEntityRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/*
* 하나의 트랜잭션으로 묶여있음 (중요)
* @DataJpaTest 해당 어노테이션 내부 들어가서 묶여있는 어노테이션 체크
* @TestInstance junut에 설정된 테스트 단위로 객체를 만드는것, 테스트 실행 범위라고 보면 됨.
* */
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCase {
    @Autowired
    private TestEntityRepository testEntityRepository;

    @Autowired
    private Test2EntityRepository test2EntityRepository;

    @Autowired
    private TestEntityManager testEntityManager;



    @BeforeAll
    public void init() {
    }

//    @BeforeEach
//    @AfterEach

    @AfterAll
    public void clear() {

    }

    /**
     * 해당 옵션을 사용하고 안하고의 차이를 체크.
     * 플러시X: 샐렉트
     * 플러시O: 셀렉트 -> 인서트
     */
    @Test
    public void testCase1() {
        TestEntity testEntity = TestEntity
                .builder()
                .id(1L)
                .name("test")
                .build();
        TestEntity saveTestEntity = testEntityRepository.save(testEntity);

        // TestEntity findTestEntity = testEntityRepository.findById(1L).orElseThrow();

        testEntity.setName("111");
        // TestEntity saveTestEntity2 = testEntityRepository.save(testEntity);

        // TestEntity findTestEntity2 = testEntityRepository.findById(1L).orElseThrow();

        // testEntityManager.flush();
    }

    @Test
    public void testCase2() {
        Test2Entity testEntity = Test2Entity
                .builder()
                .name("test")
                .build();
        test2EntityRepository.save(testEntity);
    }

    @Test
    public void testCase3() {
        TestEntity testEntity = TestEntity
                .builder()
                .id(1L)
                .name("test")
                .build();
        TestEntity saveTestEntity = testEntityRepository.save(testEntity);

        saveTestEntity.setName("2222");

        testEntityManager.flush();
    }
}
