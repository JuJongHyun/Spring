package hello.hellospring.domain;

//회원 객체
public class Member {

    //시스템 저장하는 ID -> 구분
    //데이터 타입은 wrapper class Long Type
    //그 이유는 기본형인 long을 사용하면 객체를 생성하는 시점에 id값에 0이라는 기본값이 들어가는 반면,
    //Long을 사용하면 기본값이 null이기 때문에 값이 없다는 것을 잘 표현할 수 있기 때문에

    private Long id;
    private String name;

    // - getter and setter
    // 메서드는 외부에서 직접적인 접근을 막아 데이터를 보호하기 위해 사용된다.
    // getter(획득자)는 인스턴스 변수를 반환
    // setter(설정자)는 인스턴스 변수를 할당


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
