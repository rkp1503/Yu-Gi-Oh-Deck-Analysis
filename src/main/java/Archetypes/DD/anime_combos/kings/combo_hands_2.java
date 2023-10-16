/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package Archetypes.DD.anime_combos.kings;

import YuGiOh.myFunc;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class combo_hands_2 {
	static ArrayList<ArrayList<String>> get_starting_hands() {
		ArrayList<ArrayList<String>> starting_hands = new ArrayList<>();
		String card_1 = "D/D Savant Kepler";
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		ArrayList<String> tuners = new ArrayList<>(Arrays.asList("D/D Lamia", "D/D Ghost", "D/D Nighthowl", "D/D Orthros"));
		for (String card_2 : cards) {
			for (String card_3 : tuners) {
				starting_hands.add(new ArrayList<>(Arrays.asList(card_1, card_2, card_3)));
			}
		}
		return starting_hands;
	}

	static boolean lamia_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1.
		 */
		return true;
	}

	static boolean lamia_line_X(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1.
		 */
		return true;
	}

	static boolean orthros_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Copernicus/Swirl
			3. Swirl eff (hand); FS Genghis [Swirl + Orthros]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Gryphon
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Berfomet
			9. PS Copernicus (ED) + Berfomet
			10. Ragnarok PE; Revive Orthros
			11. Berfomet eff; Change Copernicus's level to 3
			12. SS Alexander [Orthros + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		return true;
	}

	static ArrayList<myFunc> get_lamia_lines() {
		return new ArrayList<>(Arrays.asList(
				// combo_hands_2::lamia_line_1
				// , combo_hands_2::lamia_line_2
				// , combo_hands_2::lamia_line_3
				// , combo_hands_2::lamia_line_4
		));
	}

	static ArrayList<myFunc> get_ghost_lines() {
		return new ArrayList<>(Arrays.asList(
				// combo_hands_2::ghost_line_1
				// , combo_hands_2::ghost_line_2
		));
	}

	static ArrayList<myFunc> get_nighthowl_lines() {
		return new ArrayList<>(Arrays.asList(
				// combo_hands_2::nighthowl_line_1
				// , combo_hands_2::nighthowl_line_2
				// , combo_hands_2::nighthowl_line_3
				// , combo_hands_2::nighthowl_line_4
		));
	}

	static ArrayList<myFunc> get_orthros_lines() {
		return new ArrayList<>(Arrays.asList(
				// combo_hands_2::orthros_line_1
				// , combo_hands_2::orthros_line_2
		));
	}
}
