package mainQcmMix.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import mainQcmMix.MainQcmMix;
import mainQcmMix.controle.openSources;

public class rootQcmMixListener {

	private MainQcmMix  mainQcmMix;
	FileChooser fileChooser = new FileChooser();
	openSources openXml = new openSources();
	String path = null;
	File file = null;
	@FXML
	private TextField textfield;
	@FXML
	private TextArea textarea;

	public MainQcmMix getMainQcmMix() {
		return mainQcmMix;
	}


	public void setMainQcmMix(MainQcmMix mainQcmMix) {
		this.mainQcmMix = mainQcmMix;
	}
	@FXML
    private void handleOpenXls() {
		String n = "xls";
		fileChooser = openXml.openSource(n);
        file = fileChooser.showOpenDialog(mainQcmMix.getPrimaryStage());

        if(file == null){
        	textfield.setText("choisir votre resources......");
        	textarea.setWrapText(true);
        	textarea.setText("votre resources sont perdu, choisissez un nouveau......");
        }else{
        	  path = file.getAbsolutePath();
        	  textfield.setText(path);
        	  textarea.setWrapText(true);
              textarea.setText("votre resources sont bon, et ils sont dans :"+path);

        }
}

	@FXML
    private void handleOpenDoc() {
		String n = "doc";
		fileChooser = openXml.openSource(n);
        file = fileChooser.showOpenDialog(mainQcmMix.getPrimaryStage());


        if(file == null){
        	textfield.setText("choisir votre resources......");
        	textarea.setWrapText(true);
        	textarea.setText("votre resources sont perdu,choisissez un nouveau......");

        }else{
        	  path = file.getAbsolutePath();
        	  textfield.setText(path);
        	  textarea.setWrapText(true);
              textarea.setText("votre resources sont bon, et ils sont dans :"+path);

        }

}
	@FXML
    private void handleOpenXml() {
		String n = "xml";
		fileChooser = openXml.openSource(n);
        file = fileChooser.showOpenDialog(mainQcmMix.getPrimaryStage());


        if(file == null){
        	textfield.setText("choisir votre resources......");
        	textarea.setWrapText(true);
        	textarea.setText("votre resources sont perdu, choisissez un nouveau......");
        }else{
        	  path = file.getAbsolutePath();
        	  textfield.setText(path);
        	  textarea.setWrapText(true);
              textarea.setText("votre resources sont bon, et ils sont dans :"+path);

        }
}
	@FXML
	private void handleCreer(){

	}
	@FXML
	private void handleDeleteResources(){
		textfield.setText("choisissez un nouveau ...");
		textarea.setWrapText(true);
		textarea.setText("votre resources sont deletes,ils sont dans :" +path);
		path = null;
		file = null;
		fileChooser = null;

	}

}
