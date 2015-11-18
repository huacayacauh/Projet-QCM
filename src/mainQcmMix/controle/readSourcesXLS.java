package mainQcmMix.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.text.html.parser.Entity;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import mainQcmMix.model.Qcm;
import mainQcmMix.util.IsBlankRow;

public class readSourcesXLS {

	POIFSFileSystem fileXls;
	HSSFWorkbook workBook;
	HSSFSheet sheet;
	TreeMap<Integer, Qcm> qcmList = new TreeMap<Integer, Qcm>();
	Qcm qcm1 = new Qcm();
	Qcm qcm2 = new Qcm();
	IsBlankRow isblankrow = new IsBlankRow();

	@SuppressWarnings("deprecation")
	public File readXLS(File file) {

		try {
			fileXls = new POIFSFileSystem(new FileInputStream(file));
			workBook = new HSSFWorkbook(fileXls);
			sheet = workBook.getSheetAt(0);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFRow hrow = null;
		String data = null;
		int num = 0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			hrow = sheet.getRow(i);
			if (hrow != null) {
				if (hrow.getLastCellNum() > 0) {

					for (int j = 0; j < hrow.getLastCellNum(); j++) {
						num = 0;
						data = "";
						if (hrow.getCell((short) j) != null) {

							switch (hrow.getCell((short) j).getCellType()) {

							case HSSFCell.CELL_TYPE_BLANK:
								data = "";
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								num = (int) hrow.getCell((short) j).getNumericCellValue();
								break;
							default:
								data = hrow.getCell((short) j).getStringCellValue();
								break;
							}

							if (j == 2 && i > 0 && isblankrow.isBlankrow(sheet.getRow(i - 1))
									&& isblankrow.isBlankrow(sheet.getRow(i + 1))) {
								qcm1.setPartie(data);

							}
							if (j == 5 && i > 0 && isblankrow.isBlankrow(sheet.getRow(i - 1))
									&& isblankrow.isBlankrow(sheet.getRow(i + 1))) {
								qcm2.setPartie(data);

							}

							if (j == 0 && num > 0) {

								qcm1.setId(num);
								qcm1.setTitle(hrow.getCell((short) (j + 2)).getStringCellValue());
							}
							if (j == 3 && num > 0) {
								qcm2.setId(num);
								qcm2.setTitle(hrow.getCell((short) (j + 2)).getStringCellValue());

							}

							if (j == 1 && data.equals("a")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm1.setChoix1(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm1.setChoix1(hrow.getCell((short) (j + 1)).getStringCellValue());
								}
							}

							if (j == 4 && data.equals("a")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm2.setChoix1(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm2.setChoix1(hrow.getCell((short) (j + 1)).getStringCellValue());
								}

							}

							if (j == 1 && data.equals("b")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm1.setChoix2(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm1.setChoix2(hrow.getCell((short) (j + 1)).getStringCellValue());
								}

							}

							if (j == 4 && data.equals("b")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm2.setChoix2(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm2.setChoix2(hrow.getCell((short) (j + 1)).getStringCellValue());
								}

							}

							if (j == 1 && data.equals("c")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm1.setChoix3(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm1.setChoix3(hrow.getCell((short) (j + 1)).getStringCellValue());
								}

							}

							if (j == 4 && data.equals("c")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm2.setChoix3(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									qcm2.setChoix3(hrow.getCell((short) (j + 1)).getStringCellValue());
								}

							}
							if (j == 1 && data.equals("d")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm1.setChoix4(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									if (isblankrow.isBlankrow(sheet.getRow(i + 1))) {
										qcm1.setChoix4(hrow.getCell(j + 1).getStringCellValue());
									} else {
										System.out.println("i = " + (i + 1) + "," + (j + 1));
										String s = hrow.getCell((short) (j + 1)).getStringCellValue();
										// + sheet.getRow(i + 1).getCell((short)
										// (j + 1)).getStringCellValue();
										qcm1.setChoix4(s);
									}

								}
								qcmList.put(qcm1.getId(), qcm1);
								qcm1 = new Qcm();

							}
							if (j == 4 && data.equals("d")) {
								if (hrow.getCell((short) (j + 1)).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									qcm2.setChoix4(hrow.getCell((short) (j + 1)).getNumericCellValue() + "");
								} else {
									if (isblankrow.isBlankrow(sheet.getRow(i + 1))) {
										qcm2.setChoix4(hrow.getCell((short) (j + 1)).getStringCellValue());

									} else {
										String s = hrow.getCell((short) (j + 1)).getStringCellValue()
												+ sheet.getRow(i + 1).getCell((short) (j + 1)).getStringCellValue();
										qcm2.setChoix4(s);
									}

								}
								qcmList.put(qcm2.getId(), qcm2);
								qcm2 = new Qcm();

							}

						}

					}

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
			return filet;
		}
		WriteXls writexls = new WriteXls();
		writexls.exportXls(qcmList, filet);
		return filet;

	}

}
