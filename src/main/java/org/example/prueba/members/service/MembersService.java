package org.example.prueba.members.service;

import org.example.prueba.members.dto.MembersRequest;
import org.example.prueba.members.dto.MembersResponseDto;

import java.util.List;

public interface MembersService {

    MembersResponseDto createMember(MembersRequest req);
    MembersResponseDto updateMember(Long id, MembersRequest req);
    void deleteMember(Long id);
    MembersResponseDto getById(Long id);
    List<MembersResponseDto> listAllMember();

}
