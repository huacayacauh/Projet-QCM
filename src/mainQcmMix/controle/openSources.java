package mainQcmMix.controle;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;

public class openSources {

	public List<String> list = new ArrayList<String>();

	public FileChooser openSource() {

		list.add("*.xls");
		FileChooser.ExtensionFilter extFilter = null;
		FileChooser fileChooser = new FileChooser();
		extFilter = new FileChooser.ExtensionFilter(".xls files", list);
		fileChooser.getExtensionFilters().add(extFilter);
		return fileChooser;
	}
}
