/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package YuGiOh;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ComboSubCategory {
	private final String combo_sub_category;
	private final ArrayList<ComboLine> combo_lines = new ArrayList<>();
	private int combo_in_hand_count = 0;
	private int full_combo_count = 0;

	public ComboSubCategory(String combo_sub_category) {
		this.combo_sub_category = combo_sub_category;
	}

	private String get_combo_sub_category() {
		return this.combo_sub_category;
	}

	ArrayList<ComboLine> get_combo_lines() {
		return this.combo_lines;
	}

	public void add_combo_category(ComboLine combo_line) {
		this.combo_lines.add(combo_line);
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
		return new ArrayList<>(src);
	}

	Pair<Boolean, Boolean> test_hand(ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		ArrayList<Boolean> cih_lst = new ArrayList<>();
		ArrayList<Boolean> fc_lst = new ArrayList<>();
		for (ComboLine combo_line : this.combo_lines) {
			Pair<Boolean, Boolean> tuple = combo_line.test_hand(copy(hand), copy(main_deck), copy(extra_deck), db_main, db_helper);
			Boolean cih_cc = tuple.getValue0();
			Boolean fc_cc = tuple.getValue1();
			cih_lst.add(cih_cc);
			fc_lst.add(fc_cc);
		}
		boolean cih = cih_lst.contains(true);
		boolean fc = fc_lst.contains(true);
		if (cih) {
			this.combo_in_hand_count += 1;
			if (fc) {
				this.full_combo_count += 1;
			}
		}
		return Pair.with(cih, fc);
	}

	void print_analysis(int n, int analysis_level) {
		double p_a = (double) this.full_combo_count / n;
		double p_b = (double) this.combo_in_hand_count / n;
		double p_c;
		if (p_b > 0) {
			p_c = p_a / p_b;
		} else {
			p_c = -1;
		}
		System.out.println("\t" + this.combo_sub_category + ": [" + String.format("%.3f", 100 * p_a) + "% | " + String.format("%.3f", 100 * p_b) + "% | " + String.format("%.3f", 100 * p_c) + "%]");
		if (analysis_level > 2) {
			for (ComboLine combo_line : this.combo_lines) {
				combo_line.print_analysis(n);
			}
		}
	}
}
