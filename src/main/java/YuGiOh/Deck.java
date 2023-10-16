/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package YuGiOh;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Deck {
	private final ArrayList<String> main_deck = new ArrayList<>();
	private final ArrayList<String> extra_deck = new ArrayList<>();
	private final ArrayList<String> side_deck = new ArrayList<>();
	private final ArrayList<ComboCategory> combo_categories = new ArrayList<>();
	private int combo_in_hand_count = 0;
	private int full_combo_count = 0;

	public ArrayList<String> get_main_deck() {
		return this.main_deck;
	}

	public void add_card_to_main_deck(String card_name) {
		this.main_deck.add(card_name);
	}

	private ArrayList<String> get_extra_deck() {
		return this.extra_deck;
	}

	public void add_card_to_extra_deck(String card_name) {
		this.extra_deck.add(card_name);
	}

	private ArrayList<String> get_side_deck() {
		return this.side_deck;
	}

	public void add_card_to_side_deck(String card_name) {
		this.side_deck.add(card_name);
	}

	private void print_deck() {
		String header = " Main Deck ";
		print_deck_helper(header, this.main_deck);
		header = " Extra Deck ";
		print_deck_helper(header, this.extra_deck);
		header = " Side Deck ";
		print_deck_helper(header, this.side_deck);
	}

	private void print_deck_helper(String header, ArrayList<String> deck_type) {
		int n = (80 - header.length()) / 2;
		System.out.println("~".repeat(n) + header + "~".repeat(n));
		int copies = 0;
		String current_card = "";
		for (String card : deck_type) {
			if (!current_card.equals(card)) {
				if (!current_card.isEmpty()) {
					String msg = copies + "x " + current_card;
					System.out.println(msg);
				}
				copies = 0;
				current_card = card;
			}
			copies += 1;
		}
		String msg = copies + "x " + current_card;
		System.out.println(msg);
	}

	private ArrayList<String> copy(ArrayList<String> src) {
		return new ArrayList<>(src);
	}

	private ArrayList<ComboCategory> get_combo_categories() {
		return this.combo_categories;
	}

	public void add_combo_category(ComboCategory combo_category) {
		this.combo_categories.add(combo_category);
	}

	public int get_combo_line_count() {
		int i = 0;
		for (ComboCategory cc : this.combo_categories) {
			for (ComboSubCategory csc : cc.get_combo_subcategories()) {
				i += csc.get_combo_lines().size();
			}
		}
		return i;
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

	public void analyze(int n, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		ArrayList<String> main_deck_src = copy(this.main_deck);
		for (int i = 0; i < n; i++) {
			Collections.shuffle(main_deck_src);
			ArrayList<String> hand = new ArrayList<>(main_deck_src.subList(0, 5));
			ArrayList<String> main_deck = new ArrayList<>(main_deck_src.subList(5, main_deck_src.size()));
			ArrayList<Boolean> cih_lst = new ArrayList<>();
			ArrayList<Boolean> fc_lst = new ArrayList<>();
			for (ComboCategory combo_category : this.combo_categories) {
				Pair<Boolean, Boolean> tuple = combo_category.test_hand(hand, main_deck, this.extra_deck, db_main, db_helper);
				Boolean cih_cc = tuple.getValue0();
				Boolean fc_cc = tuple.getValue1();
				cih_lst.add(cih_cc);
				fc_lst.add(fc_cc);
			}
			if (cih_lst.contains(true)) {
				this.combo_in_hand_count += 1;
				if (fc_lst.contains(true)) {
					this.full_combo_count += 1;
				}
			}
		}
	}

	public void print_analysis(int n) {
		print_analysis_helper(n, 1, false, -1);
	}

	public void print_analysis(int n, int analysis_level) {
		print_analysis_helper(n, analysis_level, false, -1);
	}

	public void print_analysis(int n, boolean detailed) {
		print_analysis_helper(n, 1, detailed, -1);
	}

	public void print_analysis(int n, double elapsed_time) {
		print_analysis_helper(n, 1, false, elapsed_time);
	}

	public void print_analysis(int n, int analysis_level, double elapsed_time) {
		print_analysis_helper(n, analysis_level, false, elapsed_time);
	}

	public void print_analysis(int n, boolean detailed, double elapsed_time) {
		print_analysis_helper(n, 1, detailed, elapsed_time);
	}

	public void print_analysis(int n, int analysis_level, boolean detailed) {
		print_analysis_helper(n, analysis_level, detailed, -1);
	}

	public void print_analysis(int n, int analysis_level, boolean detailed, double elapsed_time) {
		print_analysis_helper(n, analysis_level, detailed, elapsed_time);
	}

	private void print_analysis_helper(int n, int analysis_level, boolean detailed, double elapsed_time) {
		if (elapsed_time >= 0) {
			System.out.println("Finished analyzing the deck in " + String.format("%.2f", elapsed_time) + " seconds, simulating " + String.format("%,d", n) + " test hands and \ntested " + get_combo_line_count() + " combo lines.\n");
		}
		if (detailed) {
			System.out.println("[A / B / C]\nA: Probability of executing FC\nB: Probability of opening FC\nC: Probability of executing FC if opened FC\n");
		}
		for (ComboCategory category : this.combo_categories) {
			category.print_analysis(n, analysis_level);
		}
	}
}
