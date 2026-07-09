package org.example.prueba.mapper;

import org.example.prueba.church.dto.ChurchResponseDto;
import org.example.prueba.members.dto.MembersRequest;
import org.example.prueba.members.dto.MembersResponseDto;
import org.example.prueba.members.entity.MembersCh;

public class MembersMapper {

    public static MembersCh toEntityMembers(MembersRequest req) {
        MembersCh e = new MembersCh();
        e.setFirstName(req.getFirstName());
        e.setLastName(req.getLastName());
        e.setDocumentNumber(req.getDocumentNumber());
        e.setGender(req.getGender());
        e.setBirthday(req.getBirthday());
        e.setPhone(req.getPhoneNumber());
        e.setEmail(req.getEmail());
        e.setAddress(req.getAddress());
        e.setConversionDate(req.getConversionDate());
        e.setBaptismDate(req.getBaptismDate());


        return e;


    }


    public static MembersResponseDto toDTOMembers(MembersCh req) {

        MembersResponseDto e = new MembersResponseDto();
        ChurchResponseDto churchResponse = new ChurchResponseDto();
        e.setId(req.getId());

        e.setFirstName(req.getFirstName());
        e.setLastName(req.getLastName());
        e.setDocumentNumber(req.getDocumentNumber());
        e.setGender(req.getGender());
        e.setBirthday(req.getBirthday());
        e.setPhoneNumber(req.getPhone());
        e.setEmail(req.getEmail());
        e.setAddress(req.getAddress());
        e.setConversionDate(req.getConversionDate());
        e.setBaptismDate(req.getBaptismDate());
        if(req.getChurch() != null){
            churchResponse.setId(req.getChurch().getId());
            churchResponse.setAddress(req.getChurch().getAddress());
            churchResponse.setName(req.getChurch().getName());
            churchResponse.setPastorName(req.getChurch().getPastorName());
            churchResponse.setCity(req.getChurch().getCity());

            e.setChurch(churchResponse);


        }


        return e;


    }


}
