package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//회원 인터페이스
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

// Optional<T>
// Java8에서는 Optional<T> 클래스를 사용해 NPE(NullPointerException)를 방지할 수 있도록 도와준다.
// ex) findByName()을 호출하는데, Repository(DB)에 인자로 넘긴 이름(홍길동)의 회원 객체가 없을 경우(Null) NPE가 발생.
// Member member1 = memberRepository.findByName("홍길동");
// member1.getAge(); <<-- NPE 발생
// 이러한 문제를 해결하기 위해 반환타입을 옵셔널을 적용하여 사용한다.


// -findBy
//  findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다.

// -findAll
//  SELETE*ALL 과 같다. 모든 튜플을 가져온다.

// -List<T>
//  리스트 컬렉션. 리스트는 배열과 동일한 역할을 하며 크기를 지정할 필요가 없고, 제공하는 메서드를 사용할 수 있다.
//  객체이기 때문에 new 연산자를 사용해야 한다.


