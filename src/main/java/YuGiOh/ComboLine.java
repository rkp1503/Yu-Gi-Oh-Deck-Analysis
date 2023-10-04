/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */


package YuGiOh;


import org.codehaus.jettison.json.JSONObject;
import org.javatuples.Pair;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;


public class ComboLine {
	// self.func: any = func
	private String combo_line = "";
	private ArrayList<ArrayList<String>> combo_cards_list = new ArrayList<>();
	private int combo_in_hand_count = 0;
	private int full_combo_count = 0;

	private String get_combo_line() {
		return this.combo_line;
	}

	private void set_combo_line(String combo_line) {
		this.combo_line = combo_line;
	}

	private ArrayList<ArrayList<String>> get_combo_cards_list() {
		return this.combo_cards_list;
	}

	private void add_combo_cards_list(ArrayList<String> combo_cards_list) {
		this.combo_cards_list.add(combo_cards_list);
	}

	private int get_combo_in_hand_count() {
		return this.combo_in_hand_count;
	}

	private void combo_in_hand() {
		this.combo_in_hand_count += 1;
	}

	private int get_full_combo_count() {
		return this.full_combo_count;
	}

	private void full_combo() {
		this.full_combo_count += 1;
	}

	private ArrayList<String> copy(ArrayList<String> src) {
		ArrayList<String> cloned = new ArrayList<>();
		Collections.copy(cloned, src);
		return cloned;
	}

	Pair<Boolean, Boolean> test_hand(ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) {
		boolean cih = false;
		boolean fc = false;
		for (ArrayList<String> combo_cards : this.combo_cards_list) {
			// if all(card in hand for card in combo_cards):
				// cih: bool = True
				// fc: bool = self.func(copy.deepcopy(combo_cards), hand, md, ed,
				// 		db_main, db_helper)
				// if fc:
					// if not mp:
						// self.combo_in_hand_count += 1
						// self.full_combo_count += 1
						// pass
					// else:
						// with self.combo_in_hand_count_mp.get_lock():
							// self.combo_in_hand_count_mp.value += 1
							// pass
						// with self.full_combo_count_mp.get_lock():
							// self.full_combo_count_mp.value += 1
							// pass
						// pass
					// break
					// pass
				// pass
		}
		// if cih and not fc:
			// if not mp:
				// self.combo_in_hand_count += 1
				// pass
			// else:
				// with self.combo_in_hand_count_mp.get_lock():
					// self.combo_in_hand_count_mp.value += 1
					// pass
				// pass
			// pass
		return Pair.with(cih, fc);
	}

	void print_analysis(int n, int analysis_level, boolean detailed) {
		double p_a = (double) this.full_combo_count / n;
		double p_b = (double) this.combo_in_hand_count / n;
		double p_c;
		if (p_b > 0) {
			p_c = p_a / p_b;
		} else {
			p_c = -1;
		}
		System.out.println(this.combo_line + ": [" + String.format("%.2f", p_a) + " | " + String.format("%.2f", p_b) + " | " + String.format("%.2f", p_c) + "]");
	}
}
