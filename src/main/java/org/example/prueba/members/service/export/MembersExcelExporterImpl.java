package org.example.prueba.members.service.export;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.prueba.members.entity.MembersCh;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
@Service
public class MembersExcelExporterImpl  implements MembersExcelExporter{

    @Override
    public byte[] export(List<MembersCh> members) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Crear hoja
            Sheet sheet = workbook.createSheet("Miembros");

            // Crear encabezados
            createHeader(sheet);

            // Crear filas
            createRows(sheet, members);

            // Ajustar ancho de columnas
            autoSizeColumns(sheet);

            // Escribir el Excel en memoria
            workbook.write(outputStream);

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al generar el archivo Excel de miembros",
                    e
            );
        }
    }

    private void createHeader(Sheet sheet) {

        Row headerRow = sheet.createRow(0);

        String[] headers = {
                "ID",
                "Nombre",
                "Apellido",
                "DNI",
                "Género",
                "Fecha de nacimiento",
                "Teléfono",
                "Email",
                "Dirección",
                "Fecha de conversión",
                "Fecha de bautismo"
        };

        for (int i = 0; i < headers.length; i++) {

            Cell cell = headerRow.createCell(i);

            cell.setCellValue(headers[i]);

            // Estilo del encabezado
            CellStyle style = sheet.getWorkbook().createCellStyle();

            Font font = sheet.getWorkbook().createFont();
            font.setBold(true);

            style.setFont(font);

            cell.setCellStyle(style);
        }
    }

    private void createRows(
            Sheet sheet,
            List<MembersCh> members) {

        int rowNumber = 1;

        for (MembersCh member : members) {

            Row row = sheet.createRow(rowNumber++);

            row.createCell(0).setCellValue(
                    member.getId() != null
                            ? member.getId()
                            : 0
            );

            row.createCell(1).setCellValue(
                    safeString(member.getFirstName())
            );

            row.createCell(2).setCellValue(
                    safeString(member.getLastName())
            );

            row.createCell(3).setCellValue(
                    safeString(member.getDocumentNumber())
            );

            row.createCell(4).setCellValue(
                    member.getGender() != null
                            ? member.getGender().toString()
                            : ""
            );

            row.createCell(5).setCellValue(
                    member.getBirthday() != null
                            ? member.getBirthday().toString()
                            : ""
            );

            row.createCell(6).setCellValue(
                    safeString(member.getPhone())
            );

            row.createCell(7).setCellValue(
                    safeString(member.getEmail())
            );

            row.createCell(8).setCellValue(
                    safeString(member.getAddress())
            );

            row.createCell(9).setCellValue(
                    member.getConversionDate() != null
                            ? member.getConversionDate().toString()
                            : ""
            );

            row.createCell(10).setCellValue(
                    member.getBaptismDate() != null
                            ? member.getBaptismDate().toString()
                            : ""
            );
        }
    }

    private String safeString(String value) {

        return value != null ? value : "";
    }

    private void autoSizeColumns(Sheet sheet) {

        for (int i = 0; i < 11; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
