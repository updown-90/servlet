package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();


    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void findById() {
        //given
        Member member = new Member("hello", 20);
        Member savedMember = memberRepository.save(member);

        //when
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello1", 10);
        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        //when
        List<Member> findMember = memberRepository.findAll();
        assertThat(findMember.size()).isEqualTo(2);
        assertThat(findMember).contains(member1, member2);
    }
}
