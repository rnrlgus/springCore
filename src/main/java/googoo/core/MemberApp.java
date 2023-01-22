package googoo.core;

import googoo.core.member.Grade;
import googoo.core.member.Member;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "구기현", Grade.VIP);
        memberService.join(memberA);


        Member findMember = memberService.findMember(1L);
        System.out.println("new memberA = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
