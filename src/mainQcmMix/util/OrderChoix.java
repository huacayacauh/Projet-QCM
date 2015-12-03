package mainQcmMix.util;

import java.util.ArrayList;
import java.util.Random;

public class OrderChoix {

	public int[] orderCh(int i) {
		Random random = new Random();
		int[] ord = new int[i];
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean flag = true;
		while (flag) {
			int number = random.nextInt(i);
			if (!list.contains(number)) {
				list.add(number);
			}
			if (list.size() == i) {
				flag = false;
			}
		}
		for (int j = 0; j < list.size(); j++)
			ord[j] = list.get(j).intValue();
		return ord;
	}

}
