package org.example.prueba.members.repository;

import org.example.prueba.members.entity.MembersCh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MembersRepository  extends JpaRepository<MembersCh,Long> {

    Optional<Member> findByEmail(String email);
    Boolean existsByDocumentNumber(String documentNumber);


}
