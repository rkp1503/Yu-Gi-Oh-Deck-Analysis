/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package YuGiOh;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class utils {
	public static void normal_summon(String card, ArrayList<String> hand) {
		hand.remove(card);
	}

	public static boolean add_card(String card, ArrayList<String> hand, ArrayList<String> mainDeck) {
		if (!mainDeck.contains(card)) {
			return false;
		}
		hand.add(card);
		mainDeck.remove(card);
		return true;
	}

	public static boolean drew_soft_brick(String card, ArrayList<String> hand) {
		return hand.contains(card);
	}

	public static boolean activate_spell_trap_from_hand(String card, ArrayList<String> hand) {
		if (!hand.contains(card)) {
			return false;
		}
		hand.remove(card);
		return true;
	}

	public static String get_missing_piece(ArrayList<String> combo_cards, ArrayList<String> gate_targets) {
		return get_missing_pieces(combo_cards, gate_targets).getFirst();
	}

	private static ArrayList<String> get_missing_pieces(ArrayList<String> combo_cards, ArrayList<String> gate_targets) {
		ArrayList<String> missing_pieces = new ArrayList<>();
		for (String card : gate_targets) {
			if (!combo_cards.contains(card)) {
				missing_pieces.add(card);
			}
		}
		return missing_pieces;
	}

	public static void special_summon_from_hand(String monster, ArrayList<String> hand) {
		hand.remove(monster);
	}

	public static boolean dump_card(String card, ArrayList<String> main_deck) {
		if (!main_deck.contains(card)) {
			return false;
		}
		main_deck.remove(card);
		return true;
	}

	public static boolean extra_deck_summon(String monster, ArrayList<String> extra_deck) {
		if (!extra_deck.contains(monster)) {
			return false;
		}
		extra_deck.remove(monster);
		return true;
	}

	public static String find_card_by_scales(int low, int high, ArrayList<String> src, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		for (String card : src) {
			JSONObject card_data = db_main.get(db_helper.get(card));
			if (card_data.has("scale")) {
				int scale = (int) card_data.get("scale");
				if ((low <= scale) && (scale <= high)) {
					return card;
				}
			}
		}
		return null;
	}

	public static void pendulum_summon_from_hand(ArrayList<String> monsters, ArrayList<String> hand) {
		for (String monster : monsters) {
			hand.remove(monster);
		}
	}

	public static String find_card_by_level(int level, ArrayList<String> source, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		for (String card : source) {
			JSONObject card_data = db_main.get(db_helper.get(card));
			if (card_data.has("level")) {
				if ((int) card_data.get("level") == level) {
					return card;
				}
			}
		}
		return null;
	}
}
