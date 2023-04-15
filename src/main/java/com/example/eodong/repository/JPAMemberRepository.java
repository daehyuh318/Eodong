package com.example.eodong.repository;

import com.example.eodong.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JPAMemberRepository implements MemberRepository {

    private final EntityManager em;
    public JPAMemberRepository(EntityManager em){
        this.em = em;
    }


    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result =  em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}
