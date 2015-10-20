package mainQcmMix.controle;

import java.io.File;

import javafx.stage.FileChooser;

public class openSources {

	public FileChooser openSource(String signal){

		FileChooser.ExtensionFilter extFilter = null;
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir des sources XML...");

        // Set extension filter
        if(signal == "xls"){
        	 extFilter = new FileChooser.ExtensionFilter(
                     "XML files (*.xls)", "*.xls");
        }
        if(signal == "doc"){
        	 extFilter = new FileChooser.ExtensionFilter(
                     "XML files (*.doc)", "*.doc");
        }
        if(signal == "xml"){
        	extFilter = new FileChooser.ExtensionFilter(
                     "XML files (*.xml)", "*.xml");
        }


       fileChooser.getExtensionFilters().add(extFilter);

		return fileChooser;}
}
