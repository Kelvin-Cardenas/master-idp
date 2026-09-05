package org.example.prueba.members.service.export;

import org.example.prueba.members.entity.MembersCh;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MembersExportService {


    ResponseEntity<byte[]> exportExcel();

}
