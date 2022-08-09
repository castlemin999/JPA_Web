package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Spring Container 사용하기 위해
@Transactional // Test에서는 기본적으로 ROLLBACK 시킨다.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    // @Rollback(value = false) // DB에 INSERT 됨
    public void 회원가입() throws Exception {

        // given
        Member member = new Member();
        member.setName("sungmin");

        // when
        Long savedId = memberService.join(member);

        //then
        em.flush(); // DB에 반영 (Test에서 INSERT 쿼리 보기 위해)
        assertEquals(member, memberRepository.findOne(savedId));

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
            memberService.join(member2); // 예외 발생
        } catch (IllegalStateException e) {
            return;
        }

        //then
        fail("예외가 발생해야 한다.");

    }

}