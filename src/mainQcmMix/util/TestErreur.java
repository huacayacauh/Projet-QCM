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
					String sa = "Dans la source, question " + flag + " A est perdu";
					errers.add(sa);
				}
				if (qcm.getChoix2().getString().isEmpty()) {
					qcm.setFlagb(false);
					String sb = "Dans la source, question " + flag + " B est perdu";
					errers.add(sb);
				}
				if (qcm.getChoix3().getString().isEmpty()) {
					qcm.setFlagc(false);
					String sc = "Dans la source, question " + flag + " C est perdu";
					errers.add(sc);
				}
				if (qcm.getChoix4().getString().isEmpty()) {
					qcm.setFlagd(false);
					String sd = "Dans la source, question " + flag + " D est perdu";
				}
			} else {
				String ss = "Dans la source, On ne trouve pas la qestions: " + flag
						+ ", les reponses ne sont pas changer dans quatre Examens";
				errers.add(ss);
				flag = id;
			}
			flag++;
		}
		return errers;

	}

}
