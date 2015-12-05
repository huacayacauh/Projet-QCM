package mainQcmMix.util;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class IsBlankCell {

	public boolean isBlankCell(HSSFCell cell){
			boolean result = false;
			String value = "";
			if(cell != null){
				switch(cell.getCellType()){
				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					value = cell.getNumericCellValue()+"";
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue()+"";
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					value = cell.getCellFormula();
					break;
				default:
					value = "";
					break;
				}
				if(value.trim().equals("")){
					result = true;
				}
				if(value.trim().equals(" ")){
					result = true;
				}
				if(value.trim().equals("     ")){
					result = true;
				}

			}else{
				result = true;
			}
		return result;
	}
}
