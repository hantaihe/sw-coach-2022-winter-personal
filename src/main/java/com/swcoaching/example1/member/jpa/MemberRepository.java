package com.swcoaching.example1.member.jpa;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

  MemberEntity findByUsername(String username);
}
