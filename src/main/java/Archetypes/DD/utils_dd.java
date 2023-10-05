/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package Archetypes.DD;


import YuGiOh.utils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.javatuples.Pair;


import java.util.ArrayList;
import java.util.LinkedHashMap;

public class utils_dd {
	public static boolean kepler_search_contract(String card, ArrayList<String> hand, ArrayList<String> main_deck) {
		return utils.add_card(card, hand, main_deck);
	}

	public static boolean copernicus_dump(String card, ArrayList<String> main_deck) {
		return utils.dump_card(card, main_deck);
	}

	public static boolean swirl_fusion_summon(String monster, ArrayList<String> materials, ArrayList<String> hand, ArrayList<String> extra_deck) {
		if (!extra_deck.contains(monster)) {
			return false;
		}
		extra_deck.remove(monster);
		hand.remove("D/D Swirl Slime");
		for (String material : materials) {
			hand.remove(material);
		}
		return true;
	}

	public static void swirl_special_dd(String monster, ArrayList<String> hand) {
		utils.special_summon_from_hand(monster, hand);
	}

	public static boolean gate_search_dd(String monster, ArrayList<String> hand, ArrayList<String> main_deck) {
		return utils.add_card(monster, hand, main_deck);
	}

	public static boolean gryphon_search_dd(String card, ArrayList<String> hand, ArrayList<String> main_deck) {
		return utils.add_card(card, hand, main_deck);
	}

	public static boolean gilgamesh_set_scales(ArrayList<String> hand, ArrayList<String> main_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper, String a_name, String b_name) {
		String loc = null;
		if (main_deck.contains(a_name) && main_deck.contains(b_name)) {
			loc = "main deck";
		} else if (hand.contains(a_name) && hand.contains(b_name)) {
			loc = "hand";
		}
		return gilgamesh_set_scales_helper(hand, main_deck, a_name, b_name, loc);
	}

	public static boolean gilgamesh_set_scales(ArrayList<String> hand, ArrayList<String> main_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper, String a_name, int b_val) throws JSONException {
		String loc = null;
		String b_name;
		if (main_deck.contains(a_name)) {
			b_name = utils.find_card_by_scales(b_val, 13, main_deck, db_main, db_helper);
			if (b_name != null) {
				loc = "main deck";
			}
		} else {
			b_name = utils.find_card_by_scales(b_val, 13, hand, db_main, db_helper);
			if (b_name != null) {
				loc = "hand";
			}
		}
		return gilgamesh_set_scales_helper(hand, main_deck, a_name, b_name, loc);
	}

	public static boolean gilgamesh_set_scales(ArrayList<String> hand, ArrayList<String> main_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper, int a_val, String b_name) throws JSONException {
		String loc = null;
		String a_name;
		if (main_deck.contains(b_name)) {
			a_name = utils.find_card_by_scales(0, a_val, main_deck, db_main, db_helper);
			if (a_name != null) {
				loc = "main deck";
			}
		} else {
			a_name = utils.find_card_by_scales(0, a_val, hand, db_main, db_helper);
			if (a_name != null) {
				loc = "hand";
			}
		}
		return gilgamesh_set_scales_helper(hand, main_deck, a_name, b_name, loc);
	}

	public static boolean gilgamesh_set_scales(ArrayList<String> hand, ArrayList<String> main_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper, int a_val, int b_val) throws JSONException {
		String loc;
		String a_name;
		String b_name;
		String a_name_md = utils.find_card_by_scales(0, a_val, main_deck, db_main, db_helper);
		String b_name_md = utils.find_card_by_scales(b_val, 13, main_deck, db_main, db_helper);
		String a_name_h = utils.find_card_by_scales(0, a_val, hand, db_main, db_helper);
		String b_name_h = utils.find_card_by_scales(b_val, 13, hand, db_main, db_helper);
		if ((a_name_md != null) && (b_name_md != null)) {
			a_name = a_name_md;
			b_name = b_name_md;
			loc = "main deck";
		} else if ((a_name_h != null) && (b_name_h != null)) {
			a_name = a_name_h;
			b_name = b_name_h;
			loc = "hand";
		} else {
			return false;
		}
		return gilgamesh_set_scales_helper(hand, main_deck, a_name, b_name, loc);
	}

	private static boolean gilgamesh_set_scales_helper(ArrayList<String> hand, ArrayList<String> main_deck, String a_name, String b_name, String loc) {
		if (loc == null) {
			return false;
		} else {
			if (loc.equals("main deck")) {
				main_deck.remove(a_name);
				main_deck.remove(b_name);
			} else {
				hand.remove(a_name);
				hand.remove(b_name);
			}
			return true;
		}
	}
}
