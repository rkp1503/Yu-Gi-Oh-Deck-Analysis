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

public class ComboCategory {
	private final String combo_category;
	private final ArrayList<ComboSubCategory> combo_subcategories = new ArrayList<>();
	private int combo_in_hand_count = 0;
	private int full_combo_count = 0;

	public ComboCategory(String combo_category) {
		this.combo_category = combo_category;
	}

	private String get_combo_category() {
		return this.combo_category;
	}

	ArrayList<ComboSubCategory> get_combo_subcategories() {
		return this.combo_subcategories;
	}

	public void add_combo_category(ComboSubCategory combo_subcategory) {
		this.combo_subcategories.add(combo_subcategory);
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

	Pair<Boolean, Boolean> test_hand(ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		ArrayList<Boolean> cih_lst = new ArrayList<>();
		ArrayList<Boolean> fc_lst = new ArrayList<>();
		for (ComboSubCategory combo_subcategory : this.combo_subcategories) {
			Pair<Boolean, Boolean> tuple = combo_subcategory.test_hand(hand, main_deck, extra_deck, db_main, db_helper);
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
		System.out.println(this.combo_category + ": [" + String.format("%.3f", 100 * p_a) + "% | " + String.format("%.3f", 100 * p_b) + "% | " + String.format("%.3f", 100 * p_c) + "%]");
		if (analysis_level > 1) {
			for (ComboSubCategory combo_subcategory : this.combo_subcategories) {
				combo_subcategory.print_analysis(n, analysis_level);
			}
		}
	}
}
