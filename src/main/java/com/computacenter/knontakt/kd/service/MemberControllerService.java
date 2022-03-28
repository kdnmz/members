package com.computacenter.knontakt.kd.service;

import com.computacenter.knontakt.kd.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberControllerService {
    List<MemberDTO> getAllMember();

    List<MemberDTO> getMemberWithFirstname(String firstname);

    List<MemberDTO> getMemberWithName(String name);


    MemberDTO getMemberWithEmail(String email);

    MemberDTO saveMember(MemberDTO memberDTO);

    MemberDTO updateMember(MemberDTO memberDTO);

    void deleteMember(MemberDTO memberDTO);
}
