/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package Archetypes.DD.anime_combos.kings;

import YuGiOh.myFunc;
import Archetypes.DD.utils_dd;
import YuGiOh.utils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.*;

public class combo_hands_1 {
	static ArrayList<ArrayList<String>> get_starting_hands() {
		ArrayList<ArrayList<String>> starting_hands = new ArrayList<>();
		String card_1 = "D/D Savant Kepler";
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				starting_hands.add(new ArrayList<>(Arrays.asList(card_1, cards.get(i), cards.get(j))));
			}
		}
		return starting_hands;
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
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
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
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Lamia";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
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
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_2(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump "D/D" or "Dark Contract" (OPTIONAL)
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Lamia
			9. Lamia eff (Hand); Send Gate to special itself
			10. SS Alexander [Lamia + Genghis]
			11. Ragnarok PE; Revive Genghis
			12. PS Copernicus (ED)
			13. XS Caesar [Copernicus + Gryphon]
		 */
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 3;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Lamia";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_3(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Lamia
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Berfomet
			9. PS Copernicus (ED) + Berfomet (Hand)
			10. Ragnarok PE; Revive Lamia
			11. Berfomet eff; Change Copernicus's level to 6
			12. SS Alexander [Lamia + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Lamia";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
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
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_4(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Berfomet
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Lamia
			9. PS Copernicus (ED)
			10. Ragnarok PE; Revive Berfomet
			11. Berfomet eff; Change Copernicus's level to 6
			12. Lamia eff (Hand); Send Gate to special itself
			13. SS Alexander [Lamia + Copernicus]
			14. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Berfomet";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
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
		card = "D/D Lamia";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_5(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump "D/D" or "Dark Contract" (OPTIONAL)
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (0 Scale + Ragnarok)
			8. Gryphon ME; Add Lamia
			9. PS Copernicus (ED) + Lamia (Hand)
			10. SS Alexander [Lamia + Genghis]
			11. Ragnarok PE; Revive Genghis
			12. XS Caesar [Copernicus + Gryphon]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Lamia";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_6(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Berfomet
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (0 Scale + Ragnarok)
			8. Gryphon ME; Add Lamia
			9. PS Copernicus (ED) + Lamia (Hand)
			10. Ragnarok PE; Revive Berfomet
			11. Berfomet eff; Change Copernicus's level to 6
			12. SS Alexander [Lamia + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Berfomet";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Lamia";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_7(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Lamia
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + ≥5 Scale)
			8. Gryphon ME; Add Berfomet
			9. Lamia eff (GY); Send Gate to revive itself
			10. PS Copernicus (ED) + Berfomet (Hand)
			11. Berfomet eff; Change Copernicus's level to 6
			12. SS Alexander [Lamia + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Lamia";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 3;
		int scale_b_val = 5;
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_val)) {
			return false;
		}
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_8(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Lamia
			7. NS Lamia
			8. SS Alexander [Lamia + Genghis]
			9. Ragnarok PE; Revive Genghis
			10. Alexander eff; Revive Gryphon
			11. Gryphon ME; Add Headhunt
			12. PS Copernicus (ED)
			13. XS Caesar [Copernicus + Gryphon]
			14. Set Headhunt
		 */
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Lamia";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		card = "D/D/D Gust King Alexander";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D/D Wave King Caesar";
		return utils.extra_deck_summon(card, extra_deck);
	}

	static boolean lamia_line_9(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Copernicus (ED) + Berfomet (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Lamia
			10. NS Lamia
			11. Berfomet eff; Change Copernicus's Level to 6
			12. SS Alexander [Lamia + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Lamia";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_10(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (0 Scale + Ragnarok)
			6. Activate Gate; Add Lamia
			7. PS Copernicus (ED) + Lamia (Hand)
			8. SS Alexander [Lamia + Genghis]
			9. Ragnarok PE; Revive Genghis
			10. Alexander eff; Revive Gryphon
			11. Gryphon ME; Add Headhunt
			12. XS Caesar [Copernicus + Gryphon]
			13. Set Headhunt
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Lamia";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D/D Gust King Alexander";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D/D Wave King Caesar";
		return utils.extra_deck_summon(card, extra_deck);
	}

	static boolean lamia_line_11(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (0 Scale + Ragnarok)
			6. Activate Gate; Add Lamia
			7. PS Copernicus (ED) + Lamia (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Berfomet
			10. NS Berfomet
			11. Berfomet eff; Change Copernicus's Level to 6
			12. SS Alexander [Lamia + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Lamia";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean lamia_line_12(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Headhunt
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Copernicus
			7. PS Gryphon (ED) + Copernicus
			8. Copernicus ME; Dump Lamia
			9. Lamia eff (GY); Send Gate to special itself
			10. SS Alexander [Lamia + Genghis]
			11. Ragnarok PE; Revive Genghis
			12. XS Caesar [Gryphon + Copernicus]
			13. Set Headhunt
		 */
		return false;
	}

	static boolean lamia_line_13(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Gryphon (ED) + Copernicus + Berfomet
			8. Copernicus ME; Dump Lamia
			9. Berfomet eff; Change Copernicus's Level to 6
			10. XS Caesar [Gryphon + Berfomet]
			11. Ragnarok PE; Revive Lamia
			12. SS Alexander [Lamia + Copernicus]
		 */
		return false;
	}

	static boolean lamia_line_14(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (0 Scale + Ragnarok)
			6. Activate Gate; Add Lamia
			7. PS Gryphon (ED) + Copernicus + Lamia
			8. Copernicus ME; Dump any "D/D" or "Dark Contract" (OPTIONAL)
			9. SS Alexander [Lamia + Genghis]
			10. Ragnarok PE; Revive Genghis
			11. XS Caesar [Gryphon + Copernicus]
		 */
		return false;
	}

	static boolean lamia_line_15(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + ≥5 Scale)
			6. Activate Gate; Add Berfomet
			7. PS Gryphon (ED) + Copernicus + Berfomet
			8. Copernicus ME; Dump Lamia
			9. Lamia eff (GY); Send Gate to special itself
			10. Berfomet eff; Change Copernicus's Level to 6
			11. SS Alexander [Lamia + Copernicus]
			12. XS Caesar [Gryphon + Berfomet]
		 */
		return false;
	}

	static boolean ghost_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Ghost
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Berfomet
			9. PS Copernicus (ED) + Berfomet (Hand)
			10. Ragnarok PE; Revive Ghost
			11. Berfomet eff; Change Copernicus's level to 5
			12. SS Alexander [Ghost + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Ghost";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean ghost_line_2(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Berfomet
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤1 Scale + Ragnarok)
			8. Gryphon ME; Add Ghost
			9. PS Copernicus (ED) + Ghost (Hand)
			10. Ragnarok PE; Revive Berfomet
			11. Berfomet eff; Change Copernicus's level to 5
			12. SS Alexander [Ghost + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Berfomet";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 1;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Ghost";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean ghost_line_3(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Copernicus (ED) + Berfomet (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Ghost
			10. NS Ghost
			11. Berfomet eff; Change Copernicus's Level to 5
			12. SS Alexander [Ghost + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Ghost";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean ghost_line_4(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus PE; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤1 Scale + Ragnarok)
			6. Activate Gate; Add Ghost
			7. PS Copernicus (ED) + Ghost (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Berfomet
			10. NS Berfomet
			11. Berfomet eff; Change Copernicus's Level to 5
			12. SS Alexander [Ghost + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 1;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Ghost";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean ghost_line_5(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Gryphon (ED) + Copernicus + Berfomet
			8. Copernicus ME; Dump Ghost
			9. Berfomet eff; Change Copernicus's Level to 5
			10. XS Caesar [Gryphon + Berfomet]
			11. Ragnarok PE; Revive Ghost
			12. SS Alexander [Ghost + Copernicus]
		 */
		return false;
	}

	static boolean ghost_line_6(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤1 Scale + Ragnarok)
			6. Activate Gate; Add Ghost
			7. NS Copernicus; Dump Berfomet
			8. PS Gryphon (ED) + Ghost
			9. Ragnarok PE; Revive Berfomet
			10. Berfomet eff; Change Copernicus's Level to 5
			11. SS Alexander [Ghost + Copernicus]
			12. XS Caesar [Gryphon + Berfomet]
		 */
		return false;
	}

	static boolean nighthowl_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Nighthowl
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Lv4 "D/D"
			9. PS Copernicus (ED) + Lv4 "D/D" (Hand)
			10. Ragnarok PE; Revive Nighthowl
			11. SS Alexander [Nighthowl + Copernicus]
			12. XS Caesar [Gryphon + Lv4 "D/D"]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Nighthowl";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = utils.find_card_by_level(4, main_deck, db_main, db_helper);
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_2(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Lv4 "D/D"
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤2 Scale + Ragnarok)
			8. Gryphon ME; Add Nighthowl
			9. PS Copernicus (ED) + Nighthowl (Hand)
			10. SS Alexander [Nighthowl + Copernicus]
			11. Ragnarok PE; Revive Lv4 "D/D"
			12. XS Caesar [Gryphon + Lv4 "D/D"]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = utils.find_card_by_level(4, main_deck, db_main, db_helper);
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 2;
		String scale_b_name = "D/D/D Oblivion King Abyss Ragnarok";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Nighthowl";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_3(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump any "D/D" or "Dark Contract" (OPTIONAL)
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤2 Scale + Thomas)
			8. Gryphon ME; Add Nighthowl
			9. PS Copernicus (ED) + Nighthowl (Hand)
			10. SS Alexander [Nighthowl + Gryphon]
			11. Thomas PE; Add Gryphon (ED)
			12. Gryphon ME; Special itself
			13. XS Caesar [Copernicus + Gryphon]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 2;
		String scale_b_name = "D/D Savant Thomas";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Nighthowl";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_4(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump any "D/D" or "Dark Contract" (OPTIONAL)
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (0 Scale + Cerberus)
			8. Gryphon ME; Add Nighthowl
			9. PS Kepler (ED) + Copernicus (ED) + Nighthowl (Hand)
			10. SS Alexander [Nighthowl + Gryphon]
			11. Cerberus PE; Change Kepler's Level to 4
			12. XS Caesar [Copernicus + Gryphon]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D Cerberus";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "D/D Nighthowl";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_5(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. Kepler ME; Add Gate
			4. Activate Gate; Add Nighthowl
			5. NS Nighthowl; Revive Copernicus
			6. Copernicus ME; Dump Gryphon
			7. LS Gilgamesh [Kepler + Nighthowl]
			8. CL1 Gilgamesh, CL2 Genghis; Genghis revive Nighthowl, Gilgamesh scale (≤3 Scale + Ragnarok)
			9. SS Alexander [Nighthowl + Copernicus]
			10. Ragnarok PE; Revive Gryphon
			11. Gryphon ME; Add Headhunt
			12. PS Copernicus (ED)
			13. XS Caesar [Copernicus + Gryphon]
			14. Set Headhunt
		 */
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Nighthowl";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "D/D/D Gust King Alexander";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D/D Wave King Caesar";
		return utils.extra_deck_summon(card, extra_deck);
	}

	static boolean nighthowl_line_6(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus ME; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Thomas)
			6. Activate Gate; Add Nighthowl
			7. NS Nighthowl; Revive Gryphon
			8. Gryphon ME; Add Headhunt
			9. SS Alexander [Nighthowl + Gryphon]
			10. Thomas PE; Add Gryphon (ED)
			11. Gryphon ME; Special itself
			12. PS Copernicus (ED)
			13. XS Caesar [Copernicus + Gryphon]
			14. Set Headhunt
		 */
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 3;
		String scale_b_name = "D/D Savant Thomas";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Nighthowl";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_7(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus ME; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (0 Scale + Cerberus)
			6. PS Kepler (ED) + Copernicus (ED)
			7. Activate Gate; Add Nighthowl
			8. NS Nighthowl; Revive Gryphon
			9. Gryphon ME; Add Headhunt
			10. SS Alexander [Nighthowl + Copernicus]
			11. Cerberus PE; Change Kepler's Level to 4
			12. XS Caesar [Kepler + Gryphon]
			13. Set Headhunt
		 */
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 0;
		String scale_b_name = "D/D Cerberus";
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_name)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Nighthowl";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_8(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus ME; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + ≥5 Scale)
			6. Activate Gate; Add Nighthowl
			7. NS Nighthowl; Revive Gryphon
			8. Gryphon ME; Add Headhunt
			9. SS Alexander [Nighthowl + Gryphon]
			10. PS Copernicus (ED) + Gryphon (ED)
			11. XS Caesar [Copernicus + Gryphon]
			12. Set Headhunt
		 */
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
		}
		card = "D/D/D Abyss King Gilgamesh";
		if (!utils.extra_deck_summon(card, extra_deck)) {
			return false;
		}
		int scale_a_val = 3;
		int scale_b_val = 5;
		if (!utils_dd.gilgamesh_set_scales(hand, main_deck, db_main, db_helper, scale_a_val, scale_b_val)) {
			return false;
		}
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Lamia";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		card = "D/D/D Headhunt";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean nighthowl_line_9(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. Kepler ME; Add Gate
			4. Activate Gate; Add Nighthowl
			5. NS Nighthowl; Revive Gryphon
			6. Gryphon ME; Add Copernicus
			7. LS Gilgamesh [Kepler + Nighthowl]; Scale (≤3 Scale + Ragnarok)
			8. PS Copernicus
			9. CL1 Ragnarok PE, CL2 Copernicus PE; Copernicus dump Lv4 "D/D", Ragnarok revive Nighthowl
			10. SS ALexander [Nighthowl + Copernicus]
			11. Genghis eff; Revive lv4 "D/D"
			12. XS Caesar [Gryphon + Lv4 "D/D"]
		 */
		return false;
	}

	static boolean nighthowl_line_10(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + Thomas)
			6. Activate Gate; Add Nighthowl
			7. PS Gryphon (ED) + Copernicus
			8. Copernicus ME; Dump any "D/D" or "Dark Contract"
			9. NS Nighthowl
			10. SS Alexander [Nighthowl + Gryphon]
			11. Thomas PE; Add Gryphon
			12. Gryphon ME; Special itself
			13. XS Caesar [Gryphon + Copernicus]
		 */
		return false;
	}

	static boolean nighthowl_line_11(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (0 Scale + Cerberus)
			6. Activate Gate; Add Nighthowl
			7. PS Gryphon (ED) + Kepler (ED) + Copernicus + Nighthowl
			8. Copernicus ME; Dump any "D/D" or "Dark Contract" (OPTIONAL)
			9. Cerberus PE; Change Kepler's Level to 4
			10. SS Alexander [Nighthowl + Kepler]
			11. XS Caesar [Gryphon + Copernicus]
		 */
		return false;
	}

	static boolean nighthowl_line_12(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. Kepler ME; Add Gate
			4. Activate Gate; Add Nighthowl
			5. NS Nighthowl; Revive Gryphon
			6. Gryphon ME; Add Copernicus
			7. LS Giglamesh [Kepler + Nighthowl]
			8. CL1 Gilgamesh, CL2 Genghis; Genghis revive Nighthowl, Gilgamesh scale (≤3 Scale + ≥5 Scale)
			9. SS ALexander [Nighthowl + Gryphon]
			10. PS Gryphon (ED) + Copernicus
			11. Copernicus ME; Dump any "D/D" or "Dark Contract" (OPTIONAL)
			12. XS Caesar [Gryphon + Copernicus]
		 */
		return false;
	}

	static boolean orthros_line_1(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Orthros
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Berfomet
			9. PS Copernicus (ED) + Berfomet (Hand)
			10. Ragnarok PE; Revive Orthros
			11. Berfomet eff; Change Copernicus's level to 3
			10. SS Alexander [Orthros + Copernicus]
			12. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Orthros";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
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
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean orthros_line_2(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. NS Kepler; Add Gate
			2. Activate Gate; Add Gryphon/Copernicus/Swirl
			3. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			4. Swirl eff (GY); Banish itself to special Copernicus from hand
			5. Copernicus ME; Dump Berfomet
			6. LS Gilgamesh [Kepler + Copernicus]
			7. CL1 Gilgamesh, CL2 Genghis; Genghis revive Gryphon, Gilgamesh scales (≤3 Scale + Ragnarok)
			8. Gryphon ME; Add Orthros
			9. PS Copernicus (ED) + Orthros (Hand)
			10. Ragnarok PE; Revive Berfomet
			11. Berfomet eff; Change Copernicus's level to 3
			10. SS Alexander [Orthros + Copernicus]
			12. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D Savant Kepler";
		utils.normal_summon(card, hand);
		combo_cards.remove(card);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.activate_spell_trap_from_hand(card, hand);
		ArrayList<String> gate_targets = new ArrayList<>(Arrays.asList("D/D Swirl Slime", "D/D Savant Copernicus", "D/D Gryphon"));
		String missing_piece = utils.get_missing_piece(combo_cards, gate_targets);
		if (!utils_dd.gate_search_dd(missing_piece, hand, main_deck)) {
			if (!utils.drew_soft_brick(missing_piece, hand)) {
				return false;
			}
		}
		card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Gryphon")), hand, extra_deck)) {
			return false;
		}
		utils_dd.swirl_special_dd("D/D Savant Copernicus", hand);
		card = "D/D Berfomet";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
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
		card = "D/D Orthros";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean orthros_line_3(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus ME; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Copernicus (ED) + Berfomet (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Orthros
			10. NS Orthros
			11. Berfomet eff; Change Copernicus's Level to 3
			12. SS Alexander [Orthros + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Orthros";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean orthros_line_4(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Copernicus]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Copernicus, Kepler add Gate
			4. Copernicus ME; Dump Gryphon
			5. LS Gilgamesh [Kepler + Copernicus]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Orthros
			7. PS Copernicus (ED) + Orthros (Hand)
			8. Ragnarok PE; Revive Gryphon
			9. Gryphon ME; Add Berfomet
			10. NS Berfomet
			11. Berfomet eff; Change Copernicus's Level to 3
			12. SS Alexander [Orthros + Copernicus]
			13. XS Caesar [Gryphon + Berfomet]
		 */
		ArrayList<String> ps_hand = new ArrayList<>();
		String card = "D/D/D Flame King Genghis";
		if (!utils_dd.swirl_fusion_summon(card, new ArrayList<>(List.of("D/D Savant Copernicus")), hand, extra_deck)) {
			return false;
		}
		card = "D/D Savant Kepler";
		utils_dd.swirl_special_dd(card, hand);
		card = "Dark Contract with the Gate";
		if (!utils_dd.kepler_search_contract(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		card = "D/D Gryphon";
		if (!utils_dd.copernicus_dump(card, main_deck)) {
			return false;
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
		card = "Dark Contract with the Gate";
		utils.activate_spell_trap_from_hand(card, hand);
		card = "D/D Orthros";
		if (!utils_dd.gate_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
			ps_hand.add(card);
		}
		utils.pendulum_summon_from_hand(ps_hand, hand);
		card = "D/D Berfomet";
		if (!utils_dd.gryphon_search_dd(card, hand, main_deck)) {
			if (!utils.drew_soft_brick(card, hand)) {
				return false;
			}
		}
		utils.normal_summon(card, hand);
		ArrayList<String> cards = new ArrayList<>(Arrays.asList("D/D/D Gust King Alexander", "D/D/D Wave King Caesar"));
		for (String card_i : cards) {
			if (!utils.extra_deck_summon(card_i, extra_deck)) {
				return false;
			}
		}
		return true;
	}

	static boolean orthros_line_5(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤3 Scale + Ragnarok)
			6. Activate Gate; Add Berfomet
			7. PS Gryphon (ED) + Copernicus + Berfomet
			8. Copernicus ME; Dump Orthros
			9. Berfomet eff; Change Copernicus's Level to 3
			10. XS Caesar [Gryphon + Berfomet]
			11. Ragnarok PE; Revive Orthros
			12. SS Alexander [Orthros + Copernicus]
		 */
		return false;
	}

	static boolean orthros_line_6(ArrayList<String> combo_cards, ArrayList<String> hand, ArrayList<String> main_deck, ArrayList<String> extra_deck, LinkedHashMap<Integer, JSONObject> db_main, LinkedHashMap<String, Integer> db_helper) throws JSONException {
		/*
		Combo Line:
			1. Swirl eff (Hand); FS Genghis [Swirl + Gryphon]
			2. Swirl eff (GY); Special Kepler
			3. CL1 Kepler, CL2 Genghis; Genghis revive Gryphon, Kepler add Gate
			4. Gryphon PE; Add Copernicus
			5. LS Gilgamesh [Kepler + Gryphon]; Scale (≤1 Scale + Ragnarok)
			6. Activate Gate; Add Orthros
			7. NS Copernicus; Dump Berfomet
			8. PS Gryphon (ED) + Orthros
			9. Ragnarok PE; Revive Berfomet
			10. Berfomet eff; Change Copernicus's Level to 3
			11. SS Alexander [Orthros + Copernicus]
			12. XS Caesar [Gryphon + Berfomet]
		 */
		return false;
	}

	static ArrayList<myFunc> get_lamia_lines() {
		return new ArrayList<>(Arrays.asList(combo_hands_1::lamia_line_1, combo_hands_1::lamia_line_2, combo_hands_1::lamia_line_3, combo_hands_1::lamia_line_4, combo_hands_1::lamia_line_5, combo_hands_1::lamia_line_6, combo_hands_1::lamia_line_7, combo_hands_1::lamia_line_8, combo_hands_1::lamia_line_9, combo_hands_1::lamia_line_10, combo_hands_1::lamia_line_11, combo_hands_1::lamia_line_12, combo_hands_1::lamia_line_13, combo_hands_1::lamia_line_14, combo_hands_1::lamia_line_15));
	}

	static ArrayList<myFunc> get_ghost_lines() {
		return new ArrayList<>(Arrays.asList(combo_hands_1::ghost_line_1, combo_hands_1::ghost_line_2, combo_hands_1::ghost_line_3, combo_hands_1::ghost_line_4, combo_hands_1::ghost_line_5, combo_hands_1::ghost_line_6));
	}

	static ArrayList<myFunc> get_nighthowl_lines() {
		return new ArrayList<>(Arrays.asList(combo_hands_1::nighthowl_line_1, combo_hands_1::nighthowl_line_2, combo_hands_1::nighthowl_line_3, combo_hands_1::nighthowl_line_4, combo_hands_1::nighthowl_line_5, combo_hands_1::nighthowl_line_6, combo_hands_1::nighthowl_line_7, combo_hands_1::nighthowl_line_8, combo_hands_1::nighthowl_line_9, combo_hands_1::nighthowl_line_10, combo_hands_1::nighthowl_line_11, combo_hands_1::nighthowl_line_12));
	}

	static ArrayList<myFunc> get_orthros_lines() {
		return new ArrayList<>(Arrays.asList(combo_hands_1::orthros_line_1, combo_hands_1::orthros_line_2, combo_hands_1::orthros_line_3, combo_hands_1::orthros_line_4, combo_hands_1::orthros_line_5, combo_hands_1::orthros_line_6));
	}
}
