package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//private이라 함부로 접근 못하므로 set을 통해 값 넣어주고 get으로 꺼냄