package mainQcmMix.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;

import mainQcmMix.model.Qcm;
import mainQcmMix.util.createStyle;

public class WriteXls {

	@SuppressWarnings("unused")
	public void exportXls(TreeMap<Integer, Qcm> qcmList,File filet) {
		HSSFWorkbook[] workbook = new HSSFWorkbook[4];
		workbook[0] = new HSSFWorkbook();
		workbook[1] = new HSSFWorkbook();
		workbook[2] = new HSSFWorkbook();
		workbook[3] = new HSSFWorkbook();
		HSSFSheet sheet1 = workbook[0].createSheet("Examen1");
		HSSFSheet sheet2 = workbook[1].createSheet("Examen2");
		HSSFSheet sheet3 = workbook[2].createSheet("Examen3");
		HSSFSheet sheet4 = workbook[3].createSheet("Examen4");

		HSSFRow row;
		HSSFCell cell;
		Qcm qcm1 = new Qcm();
		Qcm qcm2 = new Qcm();
		createStyle style = new createStyle();
		int i = 1;
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			String ss = entry.getValue().getPartie();
			if (ss !=null && ss.length()>3) {
				if(i !=1) i=i+2;
				row = sheet1.createRow(i);
				cell = row.createCell(2);
				cell.setCellStyle(style.createBlack(workbook[0]));
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet2.createRow(i);
				cell = row.createCell(2);
				cell.setCellStyle(style.createBlack(workbook[1]));
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet3.createRow(i);
				cell = row.createCell(2);
				cell.setCellStyle(style.createBlack(workbook[2]));
				cell.setCellValue(entry.getValue().getPartie());

				row = sheet4.createRow(i);
				cell = row.createCell(2);
				cell.setCellStyle(style.createBlack(workbook[3]));
				cell.setCellValue(entry.getValue().getPartie());
				i++;
			}
			++i;
			row = sheet1.createRow(i);
			cell = row.createCell(0);
			cell.setCellStyle(style.createBlack(workbook[0]));
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellStyle(style.createBlack(workbook[0]));
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet2.createRow(i);
			cell = row.createCell(0);
			cell.setCellStyle(style.createBlack(workbook[1]));
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellStyle(style.createBlack(workbook[1]));
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet3.createRow(i);
			cell = row.createCell(0);
			cell.setCellStyle(style.createBlack(workbook[2]));
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellStyle(style.createBlack(workbook[2]));
			cell.setCellValue(entry.getValue().getTitle());

			row = sheet4.createRow(i);
			cell = row.createCell(0);
			cell.setCellStyle(style.createBlack(workbook[3]));
			cell.setCellValue(entry.getKey());
			cell = row.createCell(2);
			cell.setCellStyle(style.createBlack(workbook[3]));
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
		FileOutputStream[] file = new FileOutputStream[4];

		try {
			for(int r=0;r<4;r++){
				file[r] = new FileOutputStream("Examen/Examen"+(r+1)+".xls");
				workbook[r].write(file[r]);
				file[r].flush();
				file[r].close();
			}
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
