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
			textfield.setText("choisir votre votre fichier source");
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
			textarea.setText("Aucun fichier choisi, parcourir de nouveau...");
		} else {
			path = file.getAbsolutePath();
			textfield.setText(path);
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: green; -fx-font-size: 15;");
			textarea.setText("Le fichier source a été bien chargé depuis: " + path);

		}
	}

	// Affichage des erreurs dans la console pour le boutton generer
	@FXML
	private void handlegenerer() {
		if (file != null) {
			filelink = readxls.readXLS(file);
			//if (filelink != null && filelink.list().length == 4) {
			if (filelink != null) {
				textarea.setWrapText(true);
				textarea.setStyle("-fx-text-fill: green; -fx-font-size: 15;");
				textarea.setText(
						"Opération bien effectuée, vous trouvez 4 versions d'examens dans le dossier Examen.");
			} else {
				textarea.setWrapText(true);
				textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
				textarea.setText("la generation a echoué ,choisissez un nouveau fichier ou servez vous du rapport des erreurs pour corriger.");
			}

		} else {
			textarea.setWrapText(true);
			textarea.setStyle("-fx-text-fill: red; -fx-font-size: 15;");
			textarea.setText("Choisissez votre fichier source d'abord s'il vous plait.");

		}

	}

	// Affichage des erreurs dans la console pour le boutton ouvrir
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
