package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member { //애노테이션이 붙음으로, jpa가 관리하는 엔티티가 됨
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 값을 넣으면 db가 id를 자동생성 : Identity

    private Long id;
    //@Column(name="username")
    private String name;

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
