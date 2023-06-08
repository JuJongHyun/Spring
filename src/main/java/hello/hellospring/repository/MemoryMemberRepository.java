package hello.hellospring.repository;

import   hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
    //  -Map<K, V>
    //  Map 은 키-값 쌍으로 구성된 데이터를 저장할 수 있는 interface 형식이다.
    //  [불가능] Map<String, String> a1 = new Map<String, String>(); 직접적으로 생성이 불가능.
    //  [가능]  Map<String, String> a2 = new HashMap<String, String();

    //  Map 인터페이스의 구현체로 HashMap 등의 클래스를 사용해야 한다.
    //  HashMap 은 키와 값 형태로 데이터를 저장가능하게 해준다.

    //HashMap<String, String> a1 = new HashMap<String, String>();
    //a1.put("a1","Value1");
    //a1.put("a2","value2");

    //함수를 호출할 때 HashMap, TreeMap 등으로 접근이 가능하게 해주기에 코드의 유연함과 Map 의 구현체만 접근이 가능하게 된다.
    // JAVA 언어의 객체지향특징중 다형성에 해당되는 원리이다.

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;
    //  sequence 는 0,1,2,... 키값을 생성해준다.


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    //  filter() : 조건에 맞는 원소 추출.
    //  findAny() : 해당 스트림에서 첫 번째 요소를 참조하는 Optional 객체를 반환.
    //              두 메소드 모두 비어 있는 스트림에서는 비어있는 Optional 객체를 반환.

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    //MemoryMemberRepository 메소드 클리어
    public void clearStore() {
        store.clear();
    }

}



