package mainQcmMix.controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import mainQcmMix.model.Qcm;
import mainQcmMix.util.IsBlankRow;
import mainQcmMix.util.TestErreur;

public class GenererXLS {

	POIFSFileSystem fileXls;
	HSSFWorkbook workBook;
	HSSFSheet sheet;
	TreeMap<Integer, Qcm> qcmList = new TreeMap<Integer, Qcm>();
	List<String> erreurs = new ArrayList<String>();
	IsBlankRow isblankrow = new IsBlankRow();
	TestErreur test = new TestErreur();

	// lire le document et generer quatre fichers
	@SuppressWarnings("deprecation")
	public File readXLS(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			fileXls = new POIFSFileSystem(fis);
			workBook = new HSSFWorkbook(fileXls);
			sheet = workBook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFRow hrow = null;
		HSSFCell cell1 = null;
		HSSFCell cell2 = null;
		int pc1 = 0;
		int pc2 = 3;

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			hrow = sheet.getRow(i);
			if (hrow != null) {
				cell1 = hrow.getCell(pc1);
				cell2 = hrow.getCell(pc2);
				if (!isblankrow.isBlankrow(hrow) && cell1 != null && cell1.getCellType() == 0) {
					int id = (int) cell1.getNumericCellValue();
					qcmList.put(id, prendreQcm(id, i, pc1, sheet));
				}
				if (!isblankrow.isBlankrow(hrow) && cell2 != null && cell2.getCellType() == 0) {
					int id = (int) cell2.getNumericCellValue();
					qcmList.put(id, prendreQcm(id, i, pc2, sheet));
				}
			}
		}

		File filet = null;
		if (!qcmList.isEmpty()) {
			filet = new File("Examen");
			if (!filet.exists()) {
				filet.mkdir();

			}
		} else {
			System.out.println("qcmlist est null");
			return filet;
		}

		exportXls(qcmList, filet, fileXls);
		return filet;

	}

	// prendre la chaque qestions, et mis dans le qcm
	public Qcm prendreQcm(int id, int pl, int pc, HSSFSheet sheet) {
		Qcm qcm = new Qcm();
		qcm.setId(id);
		qcm.setPl(pl);
		qcm.setPc(pc);
		for (int i = pl + 1; i < pl + 6; i++) {
			HSSFRow row = sheet.getRow(i);
			if (row != null) {
				HSSFCell cellx = row.getCell(pc + 1);
				if (cellx != null && cellx.getCellType() == 1) {
					if (cellx.getStringCellValue().equalsIgnoreCase("a")) {
						HSSFCell cell = row.getCell(pc + 2);
						if (cell.getCellType() == 1) {
							qcm.setAl(i);
							qcm.setAc(pc + 2);
							qcm.setChoix1(cell.getRichStringCellValue());
						} else if (cell.getCellType() == 0) {
							qcm.setAl(i);
							qcm.setAc(pc + 2);
							HSSFRichTextString rts = new HSSFRichTextString((int) cell.getNumericCellValue() + "");
							qcm.setChoix1(rts);
						}

					}
					if (cellx.getStringCellValue().equalsIgnoreCase("b")) {
						HSSFCell cell = row.getCell(pc + 2);
						if (cell.getCellType() == 1) {
							qcm.setBl(i);
							qcm.setBc(pc + 2);
							qcm.setChoix2(cell.getRichStringCellValue());
						} else if (cell.getCellType() == 0) {
							qcm.setBl(i);
							qcm.setBc(pc + 2);
							HSSFRichTextString rts = new HSSFRichTextString((int) cell.getNumericCellValue() + "");
							qcm.setChoix2(rts);
						}

					}
					if (cellx.getStringCellValue().equalsIgnoreCase("c")) {
						HSSFCell cell = row.getCell(pc + 2);
						if (cell.getCellType() == 1) {
							qcm.setCl(i);
							qcm.setCc(pc + 2);
							qcm.setChoix3(cell.getRichStringCellValue());
						} else if (cell.getCellType() == 0) {
							qcm.setCl(i);
							qcm.setCc(pc + 2);
							HSSFRichTextString rts = new HSSFRichTextString((int) cell.getNumericCellValue() + "");
							qcm.setChoix3(rts);
						}

					}
					if (cellx.getStringCellValue().equalsIgnoreCase("d")) {
						HSSFCell cell = row.getCell(pc + 2);
						if (cell.getCellType() == 1) {
							qcm.setDl(i);
							qcm.setDc(pc + 2);
							qcm.setChoix4(cell.getRichStringCellValue());
						} else if (cell.getCellType() == 0) {
							qcm.setDl(i);
							qcm.setDc(pc + 2);
							HSSFRichTextString rts = new HSSFRichTextString((int) cell.getNumericCellValue() + "");
							qcm.setChoix4(rts);
						}

					}
				}
			}

		}
		return qcm;
	}

	public void exportXls(TreeMap<Integer, Qcm> qcmList, File filet, POIFSFileSystem fis) {
		erreurs = test.testErreurs(qcmList);
		HSSFWorkbook[] workbook = new HSSFWorkbook[4];
		try {
			workbook[0] = new HSSFWorkbook(fis);
			workbook[1] = new HSSFWorkbook(fis);
			workbook[2] = new HSSFWorkbook(fis);
			workbook[3] = new HSSFWorkbook(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HSSFSheet sheet1 = workbook[0].getSheetAt(0);
		HSSFSheet sheet2 = workbook[1].getSheetAt(0);
		HSSFSheet sheet3 = workbook[2].getSheetAt(0);
		HSSFSheet sheet4 = workbook[3].getSheetAt(0);

		HSSFRow row;
		HSSFCell cell;
		int i = 1;
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			int id = entry.getKey();
			int pl = entry.getValue().getPl();
			int pc = entry.getValue().getPc();
			row = sheet2.getRow(pl);
			cell = row.getCell(pc);
			if (id == cell.getNumericCellValue()) {
				// choix A
				if (entry.getValue().isFlaga()) {
					// examen2 a
					row = sheet2.getRow(entry.getValue().getAl());
					cell = row.getCell(entry.getValue().getAc());
					cell.setCellValue(entry.getValue().getChoix2());
					// examen3 a
					row = sheet3.getRow(entry.getValue().getAl());
					cell = row.getCell(entry.getValue().getAc());
					cell.setCellValue(entry.getValue().getChoix3());
					// examen4 a
					row = sheet4.getRow(entry.getValue().getAl());
					cell = row.getCell(entry.getValue().getAc());
					cell.setCellValue(entry.getValue().getChoix4());
				}
				// choix B
				if (entry.getValue().isFlagb()) {
					// examen2 b
					row = sheet2.getRow(entry.getValue().getBl());
					cell = row.getCell(entry.getValue().getBc());
					cell.setCellValue(entry.getValue().getChoix1());
					// examen3 b
					row = sheet3.getRow(entry.getValue().getBl());
					cell = row.getCell(entry.getValue().getBc());
					cell.setCellValue(entry.getValue().getChoix4());
					// examen4 b
					row = sheet4.getRow(entry.getValue().getBl());
					cell = row.getCell(entry.getValue().getBc());
					cell.setCellValue(entry.getValue().getChoix3());
				}
				// choix C

				if (entry.getValue().isFlagc()) {
					// examen2 c
					row = sheet2.getRow(entry.getValue().getCl());
					cell = row.getCell(entry.getValue().getCc());
					cell.setCellValue(entry.getValue().getChoix4());
					// examen3 c
					row = sheet3.getRow(entry.getValue().getCl());
					cell = row.getCell(entry.getValue().getCc());
					cell.setCellValue(entry.getValue().getChoix1());
					// examen4 c
					row = sheet4.getRow(entry.getValue().getCl());
					cell = row.getCell(entry.getValue().getCc());
					cell.setCellValue(entry.getValue().getChoix2());
				}

				// choix D
				if (entry.getValue().isFlagd()) {
					// examen2 d
					row = sheet2.getRow(entry.getValue().getDl());
					cell = row.getCell(entry.getValue().getDc());
					cell.setCellValue(entry.getValue().getChoix3());
					// examen3 d
					row = sheet3.getRow(entry.getValue().getDl());
					cell = row.getCell(entry.getValue().getDc());
					cell.setCellValue(entry.getValue().getChoix2());
					// examen4 d
					row = sheet4.getRow(entry.getValue().getDl());
					cell = row.getCell(entry.getValue().getDc());
					cell.setCellValue(entry.getValue().getChoix1());
				}
			}
		}
		FileOutputStream[] file = new FileOutputStream[4];

		try {
			for (int r = 0; r < 4; r++) {
				file[r] = new FileOutputStream("Examen/Examen" + (r + 1) + ".xls");
				workbook[r].write(file[r]);
				file[r].flush();
				file[r].close();

				if (erreurs.size() != 0) {
					File efile = new File("Examen/ErreursRapport.txt");
					FileWriter fw = new FileWriter(efile);
					String s = "Le fichier source contient des choix contennant des caractéres gras,"
							+ " vérifiez les fichiers générés."
							+ System.getProperty("line.separator");
					;
					fw.write(s);
					fw.flush();
					for (int j = 0; j < erreurs.size(); j++) {
						String ss = erreurs.get(j) + System.getProperty("line.separator");
						fw.write(ss);
						fw.flush();
					}
					fw.close();
				}
			}
			erreurs.clear();
			System.out.println("ok;");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
