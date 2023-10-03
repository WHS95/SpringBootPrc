package com.csrfTest.java.controller;


import com.csrfTest.java.domain.member.Member;
import com.csrfTest.java.domain.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {

    private final MemberService memberService;

    public ResourceController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/change")
    public void changeMemberNameByGet(HttpServletRequest request, @RequestParam("name") String name) {
        HttpSession httpSession = request.getSession(false);
        Member member = (Member) httpSession.getAttribute("member");
        Member persistedMember = memberService.findById(member.getId());
        persistedMember.setMemberName(name);
        memberService.updateMember(persistedMember);
    }

    @PostMapping("/change")
    public void changeMemberNameByPost(HttpServletRequest request, @ModelAttribute Member body) {
        HttpSession httpSession = request.getSession(false);
        Member member = (Member) httpSession.getAttribute("member");
        Member persistedMember = memberService.findById(member.getId());
        persistedMember.setMemberName(body.getMemberName());
        memberService.updateMember(persistedMember);
    }
}