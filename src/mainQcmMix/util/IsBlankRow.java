package mainQcmMix.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class IsBlankRow {

	public boolean isBlankrow(HSSFRow hrow){

		// récupére le contenu d'une cellule selon son type ( teste aussi si la cellule est vide)
		if(hrow == null) return true;
		boolean result = true;
		for(int i =0;i<hrow.getLastCellNum();i++){
			HSSFCell cell = hrow.getCell(i,HSSFRow.RETURN_BLANK_AS_NULL);
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
					break;

				}
				if(!value.trim().equals("")){
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
