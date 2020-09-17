package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //컨트롤러가 생성되면서 스프링이 컨트롤러를 생성후 컨트롤러를 관리
public class MemberController {

    private final MemberService memberService;

    @Autowired//오토 와이어드를 사용하면 memberService를 스프링이 생성자를 통해 연결시켜준다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){ //포스트 값을 dto(Member)에 넣고 그 폼에서 가져온 네임을 Member에 놓는다
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = "+member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
       List<Member> members = memberService.findMembers();
       model.addAttribute("members", members);
       return "members/membersList";
    }

}
