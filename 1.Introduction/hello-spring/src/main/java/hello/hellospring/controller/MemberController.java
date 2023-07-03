package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = "+memberService.getClass());//memberService = class hello.hellospring.service.MemberService$$SpringCGLIB$$0
    }

    //url 치고 엔터만 칠땐 get방식(주로 조회)
    @GetMapping("/members/new")
    public String createForm() {
        return "members/CreateMemberForm";
    }

    //데이터를 폼같은 곳에 넣어서 전달할때
    @PostMapping("/members/new")
    public String create(MemberForm form) { //회원가입
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("memeber = " + member.getName());
        memberService.join(member);
        return "redirect:/";    //가입 끝나면 홈화면으로 보냄
    }

    //메모리에 있기 때문에 서버 내렸다가 다시 키면 날아감
    @GetMapping("/members")
    public String list(Model model){//회원조회
        List<Member> members = memberService.findMembers();//findMembers : members 다 꺼내올수 있음
        model.addAttribute("members", members);//member의 리스트 자체를 모델에 담아서 view(화면)템플릿에 다 넘길거임
        //model에다가 addAttribute로 "members"안엔 리스트로 모든 회원을 다 조회해서 담아놈
        return "members/memberList";
    }

   // @Autowired private MemberService memberService;


}
