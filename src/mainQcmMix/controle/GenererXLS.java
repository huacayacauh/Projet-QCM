package mainQcmMix.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
import mainQcmMix.util.IsBlankCell;
import mainQcmMix.util.IsBlankRow;
import mainQcmMix.util.OrderChoix;
import mainQcmMix.util.TestErreur;

public class GenererXLS {

	POIFSFileSystem fileXls;
	HSSFWorkbook workBook;
	HSSFSheet sheet;
	TreeMap<Integer, Qcm> qcmList = new TreeMap<Integer, Qcm>();
	List<String> erreurs = new ArrayList<String>();
	IsBlankRow isblankrow = new IsBlankRow();
	static String path = "";
	TestErreur te = new TestErreur();
	OrderChoix ordc = new OrderChoix();
	IsBlankCell isblankcell = new IsBlankCell();

	// lire le document et generer 4 fichers
	public File readXLS(File file, File filet) {
		try {
			FileInputStream fis = new FileInputStream(file);
			fileXls = new POIFSFileSystem(fis);
			workBook = new HSSFWorkbook(fileXls);
			sheet = workBook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String name = file.getName();
		if (!name.startsWith("!")) {
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
						Qcm qcm = new Qcm();
						qcm = prendreQcm(id, i, pc1, sheet);
						List<HSSFRichTextString> choixls = new ArrayList<HSSFRichTextString>();
						choixls = choixlist(id, i, pc1, sheet);
						List<String> errls = new ArrayList<String>();
						errls = errlist(id, i, pc1, sheet);
						qcm.setChoixs(choixls);
						qcm.setTesterreurs(errls);

						if (qcmList.containsKey(qcm.getId())) {
							String s = "La Question: " + qcm.getId()
									+ " existe déjà , il fault modifier le numéro de la question.";
							erreurs.add(s);
						} else {
							qcmList.put(id, qcm);
						}
					}
					if (!isblankrow.isBlankrow(hrow) && cell2 != null && cell2.getCellType() == 0) {
						int id = (int) cell2.getNumericCellValue();
						Qcm qcm = new Qcm();
						qcm = prendreQcm(id, i, pc2, sheet);
						List<HSSFRichTextString> choixls = new ArrayList<HSSFRichTextString>();
						choixls = choixlist(id, i, pc2, sheet);
						List<String> errls = new ArrayList<String>();
						errls = errlist(id, i, pc2, sheet);
						qcm.setChoixs(choixls);
						qcm.setTesterreurs(errls);
						if (qcmList.containsKey(qcm.getId())) {
							String s = "La Question " + qcm.getId()
									+ " existe déjà, il fault modifier le numéro de question.";
							erreurs.add(s);
						} else {
							qcmList.put(id, qcm);
						}
					}
				}
			}

		} else {

			int pc = 0;
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				HSSFRow srow = sheet.getRow(i);
				if (srow != null) {
					HSSFCell cell = srow.getCell(pc);
					if (cell != null && cell.getCellType() == 0) {
						int id = (int) cell.getNumericCellValue();
						Qcm qcm = new Qcm();
						qcm = prendreQcm2(id, i, pc, sheet);
						List<HSSFRichTextString> choixls = new ArrayList<HSSFRichTextString>();
						choixls = choixlist2(id, i, pc, sheet);
						List<String> errls = new ArrayList<String>();
						errls = errlist2(id, i, pc, sheet);
						qcm.setChoixs(choixls);
						qcm.setTesterreurs(errls);

						if (qcmList.containsKey(qcm.getId())) {
							String s = "La Question: " + qcm.getId()
									+ " existe déjà , il fault modifier le numéro de la question.";
							erreurs.add(s);
						} else {
							qcmList.put(id, qcm);
						}

					}

				}
			}
		}

		if (!filet.exists()) {
			filet.mkdir();
		}
		boolean flag = te.testerreurs(qcmList, erreurs, filet);
		if (!flag && !qcmList.isEmpty()) {
			exportXls(qcmList, filet, fileXls);
			qcmList.clear();
			erreurs.clear();
		}
		qcmList.clear();
		erreurs.clear();
		return filet;
	}

	private List<String> errlist2(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		List<String> testerreurs = new ArrayList<String>();
		int i = 1;
		while (flag) {
			String stts = "";
			HSSFRow row = sheet.getRow(pl + i);
			if (!isblankrow.isBlankrow(row)) {
				HSSFCell cell = row.getCell(pc);
				if (cell != null && cell.getCellType() == 1) {
					stts = cell.getStringCellValue();
					testerreurs.add(stts);
				} else if (cell != null && cell.getCellType() == 0) {
					stts = cell.getNumericCellValue() + "";
					testerreurs.add(stts);
				}
			}
			HSSFRow frow = sheet.getRow(pl + i + 1);
			if (isblankrow.isBlankrow(frow)) {
				flag = false;
			} else {
				HSSFCell cell1 = frow.getCell(pc);
				HSSFCell cell2 = frow.getCell(pc + 1);
				if (isblankcell.isBlankCell(cell1) && isblankcell.isBlankCell(cell2)) {
					flag = false;
				}
			}
			i++;
		}
		return testerreurs;
	}

	private List<HSSFRichTextString> choixlist2(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		List<HSSFRichTextString> choixes = new ArrayList<HSSFRichTextString>();
		int i = 1;
		while (flag) {
			HSSFRow row = sheet.getRow(pl + i);
			if (row != null) {
				HSSFCell cell = row.getCell(pc);
				if (cell != null && cell.getCellType() == 1) {
					HSSFCell cellx = row.getCell(pc + 1);
					if (cellx != null && cellx.getCellType() == 1) {
						HSSFRichTextString rts = cellx.getRichStringCellValue();
						System.out.println(rts.toString());
						choixes.add(rts);
					} else if (cellx != null && cellx.getCellType() == 0) {
						HSSFRichTextString rtss = new HSSFRichTextString((int) cellx.getNumericCellValue() + "");
						choixes.add(rtss);
					}
				}
			}
			HSSFRow frow = sheet.getRow(pl + i + 1);
			if (isblankrow.isBlankrow(frow)) {
				flag = false;
			} else {
				HSSFCell cell1 = frow.getCell(pc);
				HSSFCell cell2 = frow.getCell(pc + 1);

				if (isblankcell.isBlankCell(cell1) && isblankcell.isBlankCell(cell2)) {
					flag = false;
				}
			}
			i++;
		}
		return choixes;
	}

	private Qcm prendreQcm2(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		int i = 1;
		Qcm qcm = new Qcm();
		qcm.setId(id);
		qcm.setPl(pl);
		qcm.setPc(pc);
		while (flag) {
			HSSFRow row = sheet.getRow(pl + i);
			if (row != null) {
				HSSFCell cell = row.getCell(pc);
				if (cell != null && cell.getCellType() == 1) {
					HSSFCell cellx = row.getCell(pc + 1);
					if (cellx != null && cellx.getCellType() == 1) {
						qcm.setAl(pl + i);
						qcm.setAc(pc);
						flag = false;
					} else if (cellx != null && cellx.getCellType() == 0) {
						qcm.setAl(pl + i);
						qcm.setAc(pc);
						flag = false;
					}
				}
			}
			i++;
		}
		return qcm;
	}

	public List<HSSFRichTextString> choixlist(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		List<HSSFRichTextString> choixes = new ArrayList<HSSFRichTextString>();
		int i = 1;
		while (flag) {
			HSSFRow row = sheet.getRow(pl + i);
			if (row != null) {
				HSSFCell cell = row.getCell(pc + 1);
				if (cell != null && cell.getCellType() == 1) {
					HSSFCell cellx = row.getCell(pc + 2);
					if (cellx != null && cellx.getCellType() == 1) {
						HSSFRichTextString rts = cellx.getRichStringCellValue();
						choixes.add(rts);
					} else if (cellx != null && cellx.getCellType() == 0) {
						HSSFRichTextString rtss = new HSSFRichTextString((int) cellx.getNumericCellValue() + "");
						choixes.add(rtss);
					}
				}
			}
			HSSFRow frow = sheet.getRow(pl + i + 1);
			if (isblankrow.isBlankrow(frow)) {
				flag = false;
			} else {
				HSSFCell cell1 = frow.getCell(pc);
				HSSFCell cell2 = frow.getCell(pc + 1);
				HSSFCell cell3 = frow.getCell(pc + 2);

				if (isblankcell.isBlankCell(cell1) && isblankcell.isBlankCell(cell2)
						&& isblankcell.isBlankCell(cell3)) {
					flag = false;
				}
			}
			i++;
		}
		return choixes;
	}

	public List<String> errlist(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		List<String> testerreurs = new ArrayList<String>();
		int i = 1;
		while (flag) {
			String stts = "";
			HSSFRow row = sheet.getRow(pl + i);
			if (!isblankrow.isBlankrow(row)) {
				HSSFCell cell = row.getCell(pc + 1);
				if (cell != null && cell.getCellType() == 1) {
					stts = cell.getStringCellValue();
					testerreurs.add(stts);
				} else if (cell != null && cell.getCellType() == 0) {
					stts = cell.getNumericCellValue() + "";
					testerreurs.add(stts);
				}
			}
			HSSFRow frow = sheet.getRow(pl + i + 1);
			if (isblankrow.isBlankrow(frow)) {
				flag = false;
			} else {
				HSSFCell cell1 = frow.getCell(pc);
				HSSFCell cell2 = frow.getCell(pc + 1);
				HSSFCell cell3 = frow.getCell(pc + 2);
				if (isblankcell.isBlankCell(cell1) && isblankcell.isBlankCell(cell2)
						&& isblankcell.isBlankCell(cell3)) {
					flag = false;
				}
			}
			i++;
		}
		return testerreurs;
	}

	// prendre la chaque qestions, et mis dans le qcm
	public Qcm prendreQcm(int id, int pl, int pc, HSSFSheet sheet) {
		boolean flag = true;
		int i = 1;
		Qcm qcm = new Qcm();
		qcm.setId(id);
		qcm.setPl(pl);
		qcm.setPc(pc);
		while (flag) {
			HSSFRow row = sheet.getRow(pl + i);
			if (row != null) {
				HSSFCell cell = row.getCell(pc + 1);
				if (cell != null && cell.getCellType() == 1) {
					HSSFCell cellx = row.getCell(pc + 2);
					if (cellx != null && cellx.getCellType() == 1) {
						qcm.setAl(pl + i);
						qcm.setAc(pc + 1);
						flag = false;
					} else if (cellx != null && cellx.getCellType() == 0) {
						qcm.setAl(pl + i);
						qcm.setAc(pc + 1);
						flag = false;
					}
				}
			}
			i++;
		}
		return qcm;
	}

	public void exportXls(TreeMap<Integer, Qcm> qcmList, File filet, POIFSFileSystem fis) {

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
		List<String> key1 = new ArrayList<String>();
		List<String> key2 = new ArrayList<String>();
		List<String> key3 = new ArrayList<String>();
		List<String> key4 = new ArrayList<String>();

		String[] s = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n" };

		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			Qcm qcm = new Qcm();
			qcm = entry.getValue();
			int i = qcm.getChoixs().size();
			int[] ord2 = new int[i];
			ord2 = ordc.orderCh(i);
			String sor2 = ": ";
			for (int j = 0; j < ord2.length; j++) {
				String f = s[ord2[j]];
				sor2 += f + " ";
			}
			key2.add(sor2);
			int al = qcm.getAl();
			int ac = qcm.getAc();
			int ln = 0;
			while (ln < i) {
				HSSFRow row2 = sheet2.getRow(al + ln);
				HSSFCell cell2 = row2.createCell(ac);
				cell2.setCellValue(s[ln]);
				HSSFCell cell22 = row2.createCell(ac + 1);
				cell22.setCellValue(qcm.getChoixs().get(ord2[ln]));
				ln++;
			}
			ln = 0;
			int[] ord1 = new int[i];
			ord1 = ordc.orderCh(i);
			String sor1 = ": ";
			for (int j = 0; j < ord1.length; j++) {
				String f = s[ord1[j]];
				sor1 += f + " ";
			}
			key1.add(sor1);
			while (ln < i) {
				HSSFRow row2 = sheet1.getRow(al + ln);
				HSSFCell cell2 = row2.createCell(ac);
				cell2.setCellValue(s[ln]);
				HSSFCell cell22 = row2.createCell(ac + 1);
				cell22.setCellValue(qcm.getChoixs().get(ord1[ln]));
				ln++;
			}
			ln = 0;
			int[] ord3 = new int[i];
			ord3 = ordc.orderCh(i);
			String sor3 = ": ";
			for (int j = 0; j < ord3.length; j++) {
				String f = s[ord3[j]];
				sor3 += f + " ";
			}
			key3.add(sor3);
			while (ln < i) {
				HSSFRow row2 = sheet3.getRow(al + ln);
				HSSFCell cell2 = row2.createCell(ac);
				cell2.setCellValue(s[ln]);
				HSSFCell cell22 = row2.createCell(ac + 1);
				cell22.setCellValue(qcm.getChoixs().get(ord3[ln]));
				ln++;
			}
			ln = 0;
			int[] ord4 = new int[i];
			ord4 = ordc.orderCh(i);
			String sor4 = ": ";
			for (int j = 0; j < ord4.length; j++) {
				String f = s[ord4[j]];
				sor4 += f + " ";
			}
			key4.add(sor4);
			while (ln < i) {
				HSSFRow row2 = sheet4.getRow(al + ln);
				HSSFCell cell2 = row2.createCell(ac);
				cell2.setCellValue(s[ln]);
				HSSFCell cell22 = row2.createCell(ac + 1);
				cell22.setCellValue(qcm.getChoixs().get(ord4[ln]));
				ln++;
			}

		}

		FileOutputStream[] file = new FileOutputStream[4];
		File[] filek = new File[4];
		path = filet.getAbsolutePath();

		try {
			for (int r = 0; r < 4; r++) {
				file[r] = new FileOutputStream(path + "/ExamenV" + (r + 1) + ".xls");
				workbook[r].write(file[r]);
				file[r].flush();
				file[r].close();
			}

			for (int i = 0; i < 4; i++) {
				filek[i] = new File(path + "/key" + (i + 1) + ".txt");
				FileWriter fw = new FileWriter(filek[i]);
				String s1 = "Examen " + (i + 1) + System.getProperty("line.separator");
				fw.write(s1);
				fw.flush();
				if (i == 0) {
					for (int j = 0; j < key1.size(); j++) {
						String ss = "Q" + (j + 1) + " " + key1.get(j) + " " + System.getProperty("line.separator");
						fw.write(ss);
						fw.flush();
					}
				}
				if (i == 1) {
					for (int j = 0; j < key2.size(); j++) {
						String ss = "Q" + (j + 1) + " " + key2.get(j) + " " + System.getProperty("line.separator");
						fw.write(ss);
						fw.flush();
					}
				}
				if (i == 2) {
					for (int j = 0; j < key3.size(); j++) {
						String ss = "Q" + (j + 1) + " " + key3.get(j) + " " + System.getProperty("line.separator");
						fw.write(ss);
						fw.flush();
					}
				}
				if (i == 3) {
					for (int j = 0; j < key4.size(); j++) {
						String ss = "Q" + (j + 1) + " " + key4.get(j) + " " + System.getProperty("line.separator");
						fw.write(ss);
						fw.flush();
					}
				}
				fw.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
