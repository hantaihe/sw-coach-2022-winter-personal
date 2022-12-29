package com.swcoaching.example1.member;

import com.swcoaching.example1.member.jpa.MemberEntity;
import com.swcoaching.example1.member.jpa.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public Member findByUsername(String username) {
    MemberEntity memberEntity = memberRepository.findByUsername(username);
    return Member.of(memberEntity);
  }
}
