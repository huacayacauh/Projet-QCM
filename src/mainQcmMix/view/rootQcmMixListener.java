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

public class rootQcmMixListener {

	private MainQcmMix mainQcmMix;
	FileChooser fileChooser = new FileChooser();
	openSources opensource = new openSources();
	GenererXLS readxls = new GenererXLS();
	openDossier opendossier = new openDossier();

	String path = null;
	File file = null;
	File fsave = null;
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
		//
		fileChooser = opensource.openSource();

		file = fileChooser.showOpenDialog(mainQcmMix.getPrimaryStage());
		if (file == null) {
			textfield.setText("choisir votre votre fichier source");
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
			textarea.setText("Fichier perdu, choisissez de nouveau...");
		} else {
			path = file.getAbsolutePath();
			textfield.setText(path);
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: green; -fx-font-size: 15;");
			textarea.setText("Le fichier source a été bien chargé depuis: " + path);

		}
	}

	@FXML
	private void handlegenerer() {
		if (file != null) {
			FileChooser fc = new FileChooser();
			fc.setInitialFileName("Examens");
			fsave = fc.showSaveDialog(mainQcmMix.getPrimaryStage());
			if (fsave != null) {
				filelink = readxls.readXLS(file, fsave);
				if (filelink != null) {
					textarea.setWrapText(true);
					textarea.setStyle("-fx-text-fill: green; -fx-font-size: 15;");
					if (!GenererXLS.ExisteFile()) {
						textarea.setText(
								"Operation validée, il y a 4 versions d'examens dans le dossier " + filelink.getName());
					} else {
						textarea.setText(
								"Operation validée, il y a 4 versions d'examens dans la dossier " + filelink.getName()
										+ "\nAttention: Mauvaise structure dans la source, regardez ErrorLog !!");
					}
				} else {
					textarea.setWrapText(true);
					textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
					textarea.setText("la generation a echoué , regardez ErrorLog !");
				}

			} else {
				textarea.setWrapText(true);
				textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
				textarea.setText("Choisir le dossier déstination...");
			}
		} else {
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
			textarea.setText("Choisissez votre fichier source d'abord s'il vous plait.");

		}

	}

	@FXML
	private void openLink() {
		if (file != null) {
			if (filelink != null) {
				opendossier.openlink(filelink);
			} else {
				textarea.setWrapText(true);
				textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
				textarea.setText("Appuyez d'abord sur le boutton generer.");
			}

		} else {
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
			textarea.setText("Choisissez votre fichier source d'abord s'il vous plait.");
		}

	}
}
