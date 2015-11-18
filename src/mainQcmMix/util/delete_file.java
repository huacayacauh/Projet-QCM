package mainQcmMix.util;

import java.io.File;

public class delete_file {

	public void deleteFile() {
		File file = new File("Examen");
		if (!file.exists()) {
			file.mkdir();
		}

		if (file.list().length == 0) {
			file.delete();
		} else {
			if (file.isDirectory()) {
				String[] children = file.list();
				for (int i = 0; i < children.length; i++) {
					File file1 = new File(file, children[i]);
					file1.delete();
				}
			}
			file.delete();
		}
	}
}
