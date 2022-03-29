package com.computacenter.knontakt.kd.boundary;

import com.computacenter.knontakt.kd.dto.MemberDTO;
import com.computacenter.knontakt.kd.service.MemberControllerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {
    private final MemberControllerService memberControllerService;

    @GetMapping
    public List<MemberDTO> all() {
        return memberControllerService.getAllMember();
    }

    @GetMapping("/with/firstname/{firstname}")
    public List<MemberDTO> firstname(String firstname) {
        return memberControllerService.getMemberWithFirstname(firstname);
    }

    @GetMapping("/with/name/{name}")
    public List<MemberDTO> name(String name) {
        return memberControllerService.getMemberWithName(name);
    }

    @GetMapping("/with/email/{email}")
    public MemberDTO email(String email) {
        return memberControllerService.getMemberWithEmail(email);
    }

    @PostMapping("/add")
    public MemberDTO add(@Valid @RequestBody MemberDTO memberDTO) {
        return memberControllerService.saveMember(memberDTO);
    }
    @PutMapping("/update")
    public MemberDTO update(@Valid @RequestBody MemberDTO memberDTO) {
        return memberControllerService.updateMember(memberDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@Valid @RequestBody MemberDTO memberDTO) {
        memberControllerService.deleteMember(memberDTO);
    }
}
