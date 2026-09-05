package org.example.prueba.members.service.export;

import org.example.prueba.members.entity.MembersCh;
import org.example.prueba.members.repository.MembersRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MembersExportServiceImpl implements MembersExportService{
    private final MembersRepository membersRepository;
    private final MembersExcelExporter membersExcelExporter;

    public MembersExportServiceImpl(
            MembersRepository membersRepository,
            MembersExcelExporter membersExcelExporter) {

        this.membersRepository = membersRepository;
        this.membersExcelExporter = membersExcelExporter;
    }

    @Override
    public ResponseEntity<byte[]> exportExcel() {

        // 1. Obtener miembros desde la base de datos
        List<MembersCh> members = membersRepository.findAll();

        // 2. Generar archivo Excel
        byte[] excelFile = membersExcelExporter.export(members);

        // 3. Preparar respuesta HTTP
        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=miembros.xlsx"
                )
                .contentType(
                        MediaType.parseMediaType(
                                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                        )
                )
                .body(excelFile);
    }
}
