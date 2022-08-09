package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceReTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("sungmin");
        // when
        Long savedId = memberService.join(member);
        //then
        assertEquals(member, memberService.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("choi");
        Member member2 = new Member();
        member2.setName("choi");

        // when
        memberService.join(member1);

        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return;
        }

        //then
        fail("예외 발생");
    }
}