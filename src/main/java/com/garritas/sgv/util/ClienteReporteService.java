package com.garritas.sgv.util;

import com.garritas.sgv.model.Cliente;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class ClienteReporteService {

    public InputStream exportClientes(List<Cliente> clientes) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clientes");

        // Encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombres");
        header.createCell(2).setCellValue("Apellidos");
        header.createCell(3).setCellValue("DNI");

        int fila = 1;
        for (Cliente c : clientes) {
            Row row = sheet.createRow(fila++);
            row.createCell(0).setCellValue(c.getIdCliente());
            row.createCell(1).setCellValue(c.getNombres());
            row.createCell(2).setCellValue(c.getApellidos());
            row.createCell(3).setCellValue(c.getDni());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
