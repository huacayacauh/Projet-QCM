package mainQcmMix.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.WorkbookUtil;

public class createStyle {
	public CellStyle createBlack(HSSFWorkbook workbook){
		CellStyle style = workbook.createCellStyle();
		Font f = workbook.createFont();
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(f);
		return style;

	}

}
