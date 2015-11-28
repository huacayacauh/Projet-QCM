package mainQcmMix.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class IsPlusReponse {

	// pour tester chaque question est occupe une cell ou plus une
	public boolean isPluskeys(int pl,int pc, HSSFSheet sheet){
		boolean flag = false;
		HSSFRow row = sheet.getRow(pl+1);
		if(row != null){
			System.out.println("row is not null  "+(pl+1));
			HSSFCell cell = row.getCell(pc);
			if(cell == null){
				System.out.println("d en pas  is ont null");
				cell = row.getCell(pc+1);
				if(cell != null){
					System.out.println("d est plus key");
					flag = true;
				}
			}

		}
		return flag;
	}

}
