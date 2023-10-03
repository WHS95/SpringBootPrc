package com.csrfTest.java.controller;

import com.csrfTest.java.domain.member.Member;
import com.csrfTest.java.domain.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = {"/csrf"})
    public String index() {
        return "index";
    }

    @PostMapping("/csrf/login")
    public String login(HttpServletRequest servletRequest) {
        String memberPassword = servletRequest.getParameter("password");
        HttpSession session = servletRequest.getSession(false);
        Member member = memberService.findById(servletRequest.getParameter("id"));
        if (member == null || memberPassword == null || !memberPassword.equals(member.getPassword())) {
            session.setAttribute("member", null);
            return "redirect:/";
        }
        session.setAttribute("member", member);
        return "redirect:/csrf/main";
    }

    @GetMapping("/csrf/main")
    public String main(HttpServletRequest servletRequest, Model model) {
        HttpSession session = servletRequest.getSession(false);
        Member member = (Member) session.getAttribute("member");
        Member persistedMember = memberService.findById(member.getId());
        model.addAttribute("memberName", persistedMember.getMemberName());
        return "main";
    }
}