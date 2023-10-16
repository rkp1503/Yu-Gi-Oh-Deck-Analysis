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

public class ComboLine {
	private final myFunc combo_function;
	private final String combo_line;
	private final ArrayList<ArrayList<String>> starting_hands;
	private int combo_in_hand_count = 0;
	private int full_combo_count = 0;

	public ComboLine(myFunc combo_function, String combo_line, ArrayList<ArrayList<String>> starting_hands) {
		this.combo_function = combo_function;
		this.combo_line = combo_line;
		this.starting_hands = starting_hands;
	}

	private myFunc get_combo_function() {
		return this.combo_function;
	}

	private String get_combo_line() {
		return this.combo_line;
	}

	private ArrayList<ArrayList<String>> get_starting_hands() {
		return this.starting_hands;
	}

	private void add_starting_hand(ArrayList<String> starting_hand) {
		this.starting_hands.add(starting_hand);
	}

	private int get_combo_in_hand_count() {
		return this.combo_in_hand_count;
	}

	private void combo_in_hand() {
		this.combo_in_hand_count += 1;
	}

	private boolean is_combo_in_hand(ArrayList<String> hand, ArrayList<String> combo_cards) {
		for (String card : combo_cards) {
			if (!hand.contains(card)) {
				return false;
			}
		}
		return true;
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
		boolean cih = false;
		boolean fc = false;
		for (ArrayList<String> combo_cards : this.starting_hands) {
			if (is_combo_in_hand(hand, combo_cards)) {
				cih = true;
				fc = this.combo_function.combo_line(copy(combo_cards), copy(hand), main_deck, extra_deck, db_main, db_helper);
				if (fc) {
					this.combo_in_hand_count += 1;
					this.full_combo_count += 1;
					break;
				}
			}
		}
		if (cih && !fc) {
			this.combo_in_hand_count += 1;
		}
		return Pair.with(cih, fc);
	}

	void print_analysis(int n) {
		double p_a = (double) this.full_combo_count / n;
		double p_b = (double) this.combo_in_hand_count / n;
		double p_c;
		if (p_b > 0) {
			p_c = p_a / p_b;
		} else {
			p_c = -1;
		}
		System.out.println("\t\t" + this.combo_line + ": [" + String.format("%.3f", 100 * p_a) + "% | " + String.format("%.3f", 100 * p_b) + "% | " + String.format("%.3f", 100 * p_c) + "%]");
	}
}
