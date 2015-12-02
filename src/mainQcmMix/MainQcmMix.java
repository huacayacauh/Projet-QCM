package mainQcmMix;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainQcmMix.view.rootQcmMixListener;

public class MainQcmMix extends Application {

	private Stage primaryStage;
	private AnchorPane rootQcmPane;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("QCM-MIX");
		this.primaryStage.getIcons().add(new Image("file:resources/images/qcltitle.png"));
		this.primaryStage.setResizable(false);
		addQcmMixlistener();
	}

	public void addQcmMixlistener() {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(MainQcmMix.class.getResource("view/rootMaxPane.fxml"));
			rootQcmPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootQcmPane);
		primaryStage.setScene(scene);
		rootQcmMixListener rootlistener = loader.getController();
		rootlistener.setMainQcmMix(this);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
