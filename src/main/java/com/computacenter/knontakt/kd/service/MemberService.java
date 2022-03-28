package com.computacenter.knontakt.kd.service;

import com.computacenter.knontakt.kd.dto.MemberDTO;
import com.computacenter.knontakt.kd.mapper.BeanMapper;
import com.computacenter.knontakt.kd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService implements MemberControllerService{
    private final MemberRepository memberRepository;
    private final BeanMapper beanMapper;
    @Override
    public List<MemberDTO> getAllMember() {
        return beanMapper.toDto(memberRepository.findAll());
    }

    @Override
    public List<MemberDTO> getMemberWithFirstname(String firstname) {
        log.info("Searching for member(s) with firstname {}",firstname);
        return beanMapper.toDto(memberRepository.findByFirstName(firstname));
    }

    @Override
    public List<MemberDTO> getMemberWithName(String name) {
        log.info("Searching for member(s) with name {}",name);
        return beanMapper.toDto(memberRepository.findByName(name));
    }

    @Override
    public MemberDTO getMemberWithEmail(String email) {
        log.info("Searching for member(s) with email {}",email);
        return Optional.ofNullable(memberRepository
                .findByEmail(email))
                .map(member->beanMapper.toDto(member))
                .orElseThrow(()-> new IllegalArgumentException(String.format("No member with email %s found", email)));
    }

    @Override
    public MemberDTO saveMember(MemberDTO memberDTO) {
        log.info("Saving new member ");
        return beanMapper.toDto(memberRepository.save(beanMapper.toDao(memberDTO)));
    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) {
        log.info("Update member ");
        return beanMapper.toDto(memberRepository.save(beanMapper.toDao(memberDTO)));
    }

    @Override
    public void deleteMember(MemberDTO memberDTO) {
        log.info("Deleting member ");
        memberRepository.delete(beanMapper.toDao(memberDTO));
    }
}
