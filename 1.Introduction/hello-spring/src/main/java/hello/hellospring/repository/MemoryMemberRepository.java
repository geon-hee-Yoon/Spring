package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   //<Key,Value>메모리니까 저장할 곳 필요하므로
    private static long sequence=0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null 나올수 있으므로 Optional
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name)) //member.getName이 파라미터로 넘어온 name과 같은지. 같은 경우에만 필터링 됨
                .findAny(); //그 중에 찾으면 반환(하나라도 찾는것) 루프 돌면서 맵에서 하나도 없으면 Optional에 null이 포함돼서 반환됨

    }

    @Override
    public List<Member> findAll() { //store는 Map인데 List로 반환되는중
        return new ArrayList<>(store.values()); //store.values=Member.  Map<Long, Member> store = new HashMap<>();이므로
    }

    public void clearStore(){
        store.clear();  //스토어를 싹 비운다
    }
}
