package org.example.prueba.members.service;

import org.example.prueba.church.entity.Church;
import org.example.prueba.church.repository.ChurchRepository;
import org.example.prueba.mapper.MembersMapper;
import org.example.prueba.members.dto.MembersRequest;
import org.example.prueba.members.dto.MembersResponseDto;
import org.example.prueba.members.entity.MembersCh;
import org.example.prueba.members.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MembersServiceImpl implements MembersService{

    public final MembersRepository membersRepository;
    private final ChurchRepository churchRepository;


    public MembersServiceImpl(MembersRepository membersRepository, ChurchRepository churchRepository) {
        this.membersRepository = membersRepository;
        this.churchRepository = churchRepository;
    }


    @Override
    public MembersResponseDto createMember(MembersRequest req) {

        MembersCh entity = MembersMapper.toEntityMembers(req);

        Church church = churchRepository.findById(req.getChurchId())
                .orElseThrow(() -> new RuntimeException("Iglesia no encontrada"));

        entity.setChurch(church);

        entity = membersRepository.save(entity);

        return MembersMapper.toDTOMembers(entity);
    }

    @Override
    public MembersResponseDto updateMember(Long id, MembersRequest req) {
        return null;
    }

    @Override
    public void deleteMember(Long id) {

    }

    @Override
    public MembersResponseDto getById(Long id) {
        return null;
    }

    @Override
    public List<MembersResponseDto> listAllMember() {
        return membersRepository.findAll().stream()
                .map(MembersMapper::toDTOMembers)
                .toList();    }
}
