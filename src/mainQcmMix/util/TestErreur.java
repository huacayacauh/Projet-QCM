package mainQcmMix.util;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import mainQcmMix.model.Qcm;

public class TestErreur {
	int flag = 1;
	Qcm qcm = null;
	List<String> errers = new ArrayList<String>();

	public List<String> testErreurs(TreeMap<Integer, Qcm> qcmList) {
		for (Entry<Integer, Qcm> entry : qcmList.entrySet()) {
			int id = entry.getKey();
			if (id == flag) {
				qcm = entry.getValue();
				if (qcm.getChoix1().getString().isEmpty()) {
					qcm.setFlaga(false);
					String sa = "Dans la source, la question " + flag + " A est perdu";
					errers.add(sa);
				}
				if (qcm.getChoix2().getString().isEmpty()) {
					qcm.setFlagb(false);
					String sb = "Dans la source, la question " + flag + " B est perdu";
					errers.add(sb);
				}
				if (qcm.getChoix3().getString().isEmpty()) {
					qcm.setFlagc(false);
					String sc = "Dans la source, la question " + flag + " C est perdu";
					errers.add(sc);
				}
				if (qcm.getChoix4().getString().isEmpty()) {
					qcm.setFlagd(false);
					String sd = "Dans la source, la question " + flag + " D est perdu";
				}
			} else {
				String ss = "Dans le fichier source, On ne trouve pas la question: " + flag
						+ ", la structure a �t� pres�rv�e dans les fichiers g�n�r�s.";
				errers.add(ss);
				flag = id;
			}
			flag++;
		}
		return errers;
	}

}
