/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package Archetypes.DD.anime_combos.kings;

import YuGiOh.myFunc;
import YuGiOh.utils;
import Archetypes.DD.utils_dd;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class combo_hands_1 {
	static ArrayList<ArrayList<String>> get_starting_hands() {
		return new ArrayList<>(Arrays.asList(
				new ArrayList<>(Arrays.asList("D/D Savant Kepler", "D/D Swirl Slime", "D/D Savant Copernicus")),
				new ArrayList<>(Arrays.asList("D/D Savant Kepler", "D/D Swirl Slime", "D/D Gryphon")),
				new ArrayList<>(Arrays.asList("D/D Savant Kepler", "D/D Savant Copernicus", "D/D Gryphon"))
		));
	}

	static boolean lamia_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Lamia
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh
			   scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Headhunt
			9. Lamia eff (GY); Send Gate to special itself
			10. SS Alexander [Lamia + Genghis]
			11. Ragnarok PE; Revive Genghis
			12. PS Copernicus (ED)
			13. XS Caesar [Copernicus + Gryphon]
			14. Set Headhunt
		 */
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)){
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList(
				"D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"
		));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)){
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)){
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Lamia";
		if (!utils_dd.copernicus_dump(card, main_deck)){
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 3;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)){
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList(
				"D/D/D Gust King Alexander", "D/D/D Wave King Caesar"
		));
		for (String card_lst : cards) {
			if (!utils.extra_deck_summon(card_lst, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static ArrayList<myFunc> get_lamia_lines() {
		ArrayList<myFunc> lamia_lines = new ArrayList<>();
		lamia_lines.add(combo_hands_1::lamia_line_1);
		return lamia_lines;
	}
}
