package mainQcmMix.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import mainQcmMix.MainQcmMix;
import mainQcmMix.controle.openDossier;
import mainQcmMix.controle.openSources;
import mainQcmMix.controle.GenererXLS;
import mainQcmMix.util.delete_file;

public class rootQcmMixListener {

	private MainQcmMix mainQcmMix;
	FileChooser fileChooser = new FileChooser();
	openSources opensource = new openSources();
	GenererXLS readxls = new GenererXLS();
	openDossier opendossier = new openDossier();
	delete_file delete = new delete_file();

	String path = null;
	File file = null;
	File filelink = null;
	String spath = null;
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
	private void handleParcourir() {
		delete.deleteFile();
		fileChooser = opensource.openSource();

		file = fileChooser.showOpenDialog(mainQcmMix.getPrimaryStage());

		if (file == null) {
			textfield.setText("choisir votre resources......");
			textarea.setWrapText(true);
			textarea.setText("votre resources sont perdu, choisissez un nouveau......");
		} else {
			path = file.getAbsolutePath();
			textfield.setText(path);
			textarea.setWrapText(true);
			textarea.setText("votre resources sont bon, et ils sont dans :" + path);

		}
	}

	@FXML
	private void handlegenerer() {
		if (file != null) {
			filelink = readxls.readXLS(file);
			//if (filelink != null && filelink.list().length == 4) {
			if (filelink != null) {
				textarea.setWrapText(true);
				textarea.setText(
						"C'est bon, il y a 4 examens dans la dossier Examen. il vous faut bien regarder des caract¨¨res gras dans la reponse.");
			} else {
				textarea.setWrapText(true);
				textarea.setText("la generation est ¨¦chec ,choisissez un nouveau ou d¨¦tectez votre source .");
			}

		} else {
			textarea.setWrapText(true);
			textarea.setText("choisissez votre sources, s'il vous plait.");

		}

	}

	@FXML
	private void openLink() {
		if (file != null) {
			if (filelink != null) {
				opendossier.openlink(filelink);
			} else {
				textarea.setWrapText(true);
				textarea.setText("D'abord ,appuyez le botton generer.");
			}

		} else {
			textarea.setWrapText(true);
			textarea.setText("choisissez votre sources, s'il vous plait.");
		}

	}
}
