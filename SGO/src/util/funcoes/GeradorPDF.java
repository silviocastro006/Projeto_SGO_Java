/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.funcoes;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JTable;

public class GeradorPDF {

    public void gerarRelatorioPDF(List<String[]> dados) throws Exception {
        // Cria um PdfWriter para escrever no arquivo
        PdfWriter writer = new PdfWriter("relatorio.pdf");
        
        // Cria um PdfDocument e associa ao writer
        PdfDocument pdfDoc = new PdfDocument(writer);
        
        // Cria um Document para adicionar elementos
        Document document = new Document(pdfDoc);

        // Adiciona um título
        document.add(new Paragraph("Relatório da Tabela").setBold().setFontSize(16));

        // Adiciona os dados linha por linha
        for (String[] linha : dados) {
            document.add(new Paragraph(String.join(", ", linha)));
        }

        // Fecha o documento
        document.close();
        System.out.println("Relatório gerado: relatorio.pdf");
    }
}

