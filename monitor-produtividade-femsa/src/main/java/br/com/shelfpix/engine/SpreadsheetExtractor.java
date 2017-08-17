package br.com.shelfpix.engine;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadsheetExtractor {
	public void extract() {
		
		try {
			String fileName = "spreadsheets/teste.xlsx";
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			OPCPackage pkg = OPCPackage.open(file);
			XSSFWorkbook wb = new XSSFWorkbook(pkg);

			for (Sheet sheet : wb) {
				String name = sheet.getSheetName();
				System.out.println(name);
		        for (Row row : sheet) {
		            for (Cell cell : row) {
		            	System.out.println("Endereco: " + cell.getAddress().formatAsString());
		            	System.out.println("Coluna: " + cell.getColumnIndex());
		            	// Linha 0 e o indicador de titulo = nome de parametro
		            	System.out.println("Linha: " + cell.getRowIndex());
		            	switch (cell.getCellTypeEnum()) {
			            	case STRING:
			            		System.out.println(cell.getStringCellValue());
			            		break;
			            	case NUMERIC:
			            		System.out.println(cell.getNumericCellValue());
			            		break;
			            	case BOOLEAN:
			            		System.out.println(cell.getBooleanCellValue());
			            		break;
			            	case BLANK:
			            		System.out.println("blank");
			            		break;
							default:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									System.out.println(cell.getDateCellValue());
								} else {
									System.out.println("nao identificado");
								}
								break;
		            	}
		            }
		        }
		    }
			//wb.sheetIterator()
			wb.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
