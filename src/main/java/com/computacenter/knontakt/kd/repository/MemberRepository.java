package com.computacenter.knontakt.kd.repository;

import com.computacenter.knontakt.kd.model.MemberDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberDAO,Long> {
    List<MemberDAO> findByFirstName(String firstName);

    List<MemberDAO> findByName(String name);

    MemberDAO findByEmail(String email);
}
