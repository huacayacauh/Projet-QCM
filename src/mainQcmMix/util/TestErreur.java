package mainQcmMix.util;

import java.util.TreeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import mainQcmMix.model.Qcm;

public class TestErreur {
	int flag = 1;
	int flagid = 0;
	static Qcm qcm = null;
	public List<String> erreurs = new ArrayList<String>();

	public List<String> testerreurs(TreeMap<Integer, Qcm> qcmList) {
		erreurs.clear();
		flag = 1;
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			int id = entry.getKey();
			if (id == flag) {
				qcm = entry.getValue();
				if (qcm.getChoix1().getString().isEmpty()) {
					qcm.setFlaga(false);
					String sa = "Dans la source, la question " + flag + " Choix a est inspecifié";
					erreurs.add(sa);
				}
				if (qcm.getChoix2().getString().isEmpty()) {
					qcm.setFlagb(false);
					String sb = "Dans la source, la question " + flag + " Choix b est inspecifié";
					erreurs.add(sb);
				}
				if (qcm.getChoix3().getString().isEmpty()) {
					qcm.setFlagc(false);
					String sc = "Dans la source, la question " + flag + " Choix c est inspecifié";
					erreurs.add(sc);
				}
				if (qcm.getChoix4().getString().isEmpty()) {
					qcm.setFlagd(false);
					String sd = "Dans la source, la question " + flag + " Choix d est inspecifié";
					erreurs.add(sd);
				}
			} else {
				String ss = "Dans le fichier source, On ne trouve pas la question: " + flag
						+ ", la structure source a été préservée dans les fichiers générés";
				erreurs.add(ss);
				flag = id;
			}
			flag++;
		}
		return erreurs;
	}

}
