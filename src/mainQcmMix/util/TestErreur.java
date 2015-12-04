package mainQcmMix.util;

import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import mainQcmMix.model.Qcm;

public class TestErreur {
	public Qcm qcm = new Qcm();
	public List<String> eord = new ArrayList<String>();
	String[] s = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n" };

	public boolean testerreurs(TreeMap<Integer, Qcm> qcmList, List<String> erreurs, File file) {
		boolean flag = false;
		int g=1;
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			qcm = entry.getValue();
			int f = qcm.getId() - g;
			if(f==0){
				eord = qcm.getTesterreurs();
				int i = 0;
				while (i < eord.size()) {
					int q=i;
					while (!eord.get(i).equalsIgnoreCase(s[q])) {
						String t = "Dans la sources, la question " + qcm.getId() + ", le choix " + s[q] + " est perdu.";
						erreurs.add(t);
						if(q<s.length-1){
						q++;
						}else{
							String m = "Dans la sources, la question " + qcm.getId() + ", le choix " + eord.get(i) + " est perdu.";
							erreurs.add(m);
							break;
						}
					}
					i++;
				}

			}else{
				for(int m=0;m<f;m++){
					String s = "Dans la sources, la questin "+ (g+m) +" est perdu";
					erreurs.add(s);
				}
				eord = qcm.getTesterreurs();
				int i = 0;
				while (i < eord.size()) {
					int q=i;
					while (!eord.get(i).equalsIgnoreCase(s[q])) {
						String t = "Dans la sources, la question " + qcm.getId() + ", le choix " + s[q] + " est perdu.";
						erreurs.add(t);
						q++;
					}
					i++;
				}

				g=qcm.getId();
			}
			g++;
		}
		if (erreurs.size() > 0) {
			try {
				String path = file.getAbsolutePath();
				File efile = new File(path + "/ErrorsLog.txt");
				FileWriter fw = new FileWriter(efile);
				String s1 = "Le fichier source contient des choix avec des caracteres gras,"
						+ " verifiez les fichiers générés." + System.getProperty("line.separator");
				fw.write(s1);
				fw.flush();
				for (int j = 0; j < erreurs.size(); j++) {
					String ss = erreurs.get(j) + System.getProperty("line.separator");
					fw.write(ss);
					fw.flush();
				}
				fw.close();
				flag = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		erreurs.clear();
		return flag;
	}

}
