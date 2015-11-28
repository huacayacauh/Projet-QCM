package mainQcmMix.controle;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;

public class openSources {

	public List list = new ArrayList<String>();

	public FileChooser openSource(){

		list.add("*.xls");
		//list.add("*.doc");
		FileChooser.ExtensionFilter extFilter = null;
		FileChooser fileChooser = new FileChooser();
        extFilter = new FileChooser.ExtensionFilter(".xls files",list);
        fileChooser.getExtensionFilters().add(extFilter);
		return fileChooser;}
}
