package com.computacenter.knontakt.kd.mapper;

import com.computacenter.knontakt.kd.dto.MemberDTO;
import com.computacenter.knontakt.kd.model.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BeanMapper {
    private final DozerBeanMapper dozerBeanMapper;
    public List<MemberDAO> toDao(List<MemberDTO> dtoList){
        return mapList(dtoList,MemberDAO.class);
    }

    public MemberDAO toDao(MemberDTO dto){
        return map(dto,MemberDAO.class);
    }

    public List<MemberDTO> toDto(List<MemberDAO> dtoList){
        return mapList(dtoList,MemberDTO.class);
    }

    public MemberDTO toDto(MemberDAO dto){
        return map(dto,MemberDTO.class);
    }


    private <FROM, TO> TO  map(FROM from, Class<TO> toClass){
        return dozerBeanMapper.map(from,toClass);
    }

    private <FROM, TO> List<TO> mapList(List<FROM> fromList, final Class<TO> toClass) {
        return fromList
                .stream()
                .map(from -> this.dozerBeanMapper.map(from, toClass))
                .collect(Collectors.toList());
    }

}
