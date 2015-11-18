package mainQcmMix.controle;

import java.io.File;
import java.io.IOException;

public class openDossier {

	public void openlink(File file) {
		String filePath = file.getAbsolutePath();
		Runtime runtime = null;
		runtime = Runtime.getRuntime();
		try {
			String s = System.getProperties().getProperty("os.name");
			if (s.contains("Windows")) {
				runtime.exec("cmd /c start explorer /select,/e, " + filePath);
			} else if (s.contains("Lunix")) {
				runtime.exec("nautilus " + filePath);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (null != runtime) {
				runtime.runFinalization();
			}
		}

	}

}
