package com.example.productManageer.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productManageer.models.Product;
import com.example.productManageer.repositories.ProductRepository;

import org.apache.poi.ss.usermodel.*;

@CrossOrigin
@RestController
public class TestController {
	
	@Autowired
	ProductRepository productRepository;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}

	@RequestMapping("/getProduct")
	public Product getTestProduct() {
		Product product = new Product();
		product.setId(1);
		product.setItemNumber("0198274");
		product.setProductName("New Product");

		return product;
	}

	@RequestMapping("/read")
	public String readExcelSheet() throws FileNotFoundException, IOException {
		try {

			FileInputStream excelFile = new FileInputStream(new File("D://Product master.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				/*
				 * while (cellIterator.hasNext()) {
				 * 
				 * Cell currentCell = cellIterator.next(); //getCellTypeEnum shown as deprecated
				 * for version 3.15 //getCellTypeEnum ill be renamed to getCellType starting
				 * from version 4.0
				 * 
				 * if (currentCell.getCellTypeEnum() == CellType.STRING) {
				 * System.out.print(currentCell.getStringCellValue() + "--"); } else if
				 * (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
				 * System.out.print(currentCell.getNumericCellValue() + "--"); }
				 * 
				 * 
				 * }
				 */
				Cell currentCell = cellIterator.next();
				Product product = new Product();
				product.setItemNumber(currentCell.getStringCellValue());
				currentCell = cellIterator.next();
				product.setProductName(currentCell.getStringCellValue());
				System.out.println(product.getItemNumber());
				productRepository.save(product);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Done!!";

	}
	
	@RequestMapping("/getById")
	public Optional<Product> getById() {
		return productRepository.findById(371);
	}

}
