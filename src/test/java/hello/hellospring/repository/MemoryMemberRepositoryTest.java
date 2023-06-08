package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//회원 리포지토리 테스트케이스 작성

class MemoryMemberRepositoryTest {

    //  repository 를 인터페이스로 설계 할 경우, MemberRepository 인터페이스를 구현한 구현체의 변경이 용이.
    MemoryMemberRepository repository = new MemoryMemberRepository();


    // 한 메서드가 끝날때 마다 실행
    //  save, findByName, findAll -> clear
    //  clear();
    //  테스트 순서는 보장이 안된다. 모든 테스트는 메서드별로 따로 동작하게 설계되어야 한다.

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
       Member member = new Member();
       member.setName("spring");

       repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }


    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}

//  Junit
//  자바용 단위 테스트 도구이다. 테스트의 성공 여부를 알기 위해 Assertion 메서드를 사용.
//  assertEquals(a, b);     - 객체 A와 B가 일치함을 확인한다.
//  assertThat
//  - juint 의 assertThat
//  assertThat(T actual, Matcher<? super T>matcher);
//  assertThat(result, allof(greaterThan(0), lessThan(10)));
//  actual : 검증 대상, matcher: 로직

//  - assertj 의 assertThat
//  assertThat(T actual)
//  assertThat(result).isGreaterThan(0).isLessThan(10);

//  assertj의 assertThat은 인자로 actual(검증대상)만 받는다. 각 타입에 맞는 Assertion 메소드를 제공.
//  asertj의 assertThat이 juint의 assertThat 보다 가지는 장점은 크게 3가지가 있다.
//  1. 자동완성 2. Assertion 분류 3. 확장성






