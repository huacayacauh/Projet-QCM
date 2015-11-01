package mainQcmMix.controle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import mainQcmMix.model.Qcm;

public class WriteXls {

	@SuppressWarnings("unused")
	public void exportXls(TreeMap<Integer, Qcm> qcmList) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet1 = workbook.createSheet("Examen1");
		HSSFSheet sheet2 = workbook.createSheet("Examen2");
		HSSFSheet sheet3 = workbook.createSheet("Examen3");
		HSSFSheet sheet4 = workbook.createSheet("Examen4");

		HSSFRow row;
		HSSFCell cell;
		Qcm qcm1 = new Qcm();
		Qcm qcm2 = new Qcm();
		int i = 1;
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			String ss = entry.getValue().getPartie();
			if (ss !=null && ss.length()>3) {
				if(i !=1) i=i+2;
				row = sheet1.createRow(i);
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet2.createRow(i);
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet3.createRow(i);
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet4.createRow(i);
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().getPartie());
				i++;
			}
			++i;
			row = sheet1.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet2.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet3.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet4.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getTitle());
			i++;

			row = sheet1.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("a");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix1());

			row = sheet2.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("a");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix2());

			row = sheet3.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("a");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix3());

			row = sheet4.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("a");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix4());
			i++;

			row = sheet1.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("b");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix2());

			row = sheet2.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("b");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix1());

			row = sheet3.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("b");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix4());

			row = sheet4.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("b");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix3());
			i++;

			row = sheet1.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("c");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix3());

			row = sheet2.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("c");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix4());

			row = sheet3.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("c");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix1());

			row = sheet4.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("c");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix2());
			i++;

			row = sheet1.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("d");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix4());

			row = sheet2.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("d");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix3());

			row = sheet3.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("d");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix2());

			row = sheet4.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue("d");
			cell = row.createCell(2);
			cell.setCellValue(entry.getValue().getChoix1());
			i++;
		}

		try {
			FileOutputStream file1 = new FileOutputStream("Examen1.xls");
			workbook.write(file1);
			file1.flush();
			file1.close();
			System.out.println("ok;");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
