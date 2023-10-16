package Archetypes.DD.anime_combos.kings;

import YuGiOh.ComboLine;
import YuGiOh.ComboSubCategory;
import YuGiOh.myFunc;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class get_combos_kings {
	private static ComboSubCategory csc1() {
		/*
		Adding all combos that end on small [Genghis + Alexander + Caesar]
		with the following hands:
			1. Kepler + 2 of [Swirl/Copernicus/Gryphon]
		*/
		String desc = "Kepler + 2 of [Swirl/Copernicus/Gryphon]";
		ComboSubCategory csc = new ComboSubCategory(desc);
		int i = 1;
		ArrayList<ArrayList<String>> starting_hands = combo_hands_1.get_starting_hands();
		String tuner = "Lamia";
		for (myFunc combo_line : combo_hands_1.get_lamia_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hands);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Ghost";
		for (myFunc combo_line : combo_hands_1.get_ghost_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hands);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Nighthowl";
		for (myFunc combo_line : combo_hands_1.get_nighthowl_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hands);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Orthros";
		for (myFunc combo_line : combo_hands_1.get_orthros_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hands);
			csc.add_combo_category(cl);
			i += 1;
		}
		return csc;
	}

	private static ComboSubCategory csc2() {
		/*
		Adding all combos that end on small [Genghis + Alexander + Caesar]
		with the following hand:
			1. Kepler + Swirl/Copernicus/Gryphon + Tuner
		where the tuners are:
			1.
		*/
		String desc = "Kepler + Swirl/Copernicus/Gryphon + Tuner";
		ComboSubCategory csc = new ComboSubCategory(desc);
		int i = 1;
		ArrayList<ArrayList<String>> starting_hand = combo_hands_2.get_starting_hands();
		// String tuner = "Lamia";
		// for (myFunc combo_line : combo_hands_2.get_lamia_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Ghost";
		// for (myFunc combo_line : combo_hands_2.get_ghost_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Nighthowl";
		// for (myFunc combo_line : combo_hands_2.get_nighthowl_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Orthros";
		// for (myFunc combo_line : combo_hands_2.get_orthros_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		return csc;
	}

	private static ComboSubCategory csc3() {
		/*
		Adding all combos that end on small [Genghis + Alexander + Caesar]
		using the following hand:
			1. Kepler + Swirl + Gryphon
		*/
		String desc = "Kepler + Swirl + Gryphon";
		ComboSubCategory csc = new ComboSubCategory(desc);
		int i = 1;
		ArrayList<ArrayList<String>> starting_hand = combo_hands_3.get_starting_hands();
		String tuner = "Lamia";
		for (myFunc combo_line : combo_hands_3.get_lamia_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Ghost";
		for (myFunc combo_line : combo_hands_3.get_ghost_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Nighthowl";
		for (myFunc combo_line : combo_hands_3.get_nighthowl_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
			csc.add_combo_category(cl);
			i += 1;
		}
		tuner = "Orthros";
		for (myFunc combo_line : combo_hands_3.get_orthros_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
			csc.add_combo_category(cl);
			i += 1;
		}
		return csc;
	}

	private static ComboSubCategory csc4() {
		/*
		Adding all combos that end on small [Genghis + Alexander + Caesar]
		using any of the following hands:
			1. Kepler + Swirl/Copernicus + Tuner
		*/
		String desc = "Kepler + 2 of [Swirl/Copernicus/Gryphon]";
		ComboSubCategory csc = new ComboSubCategory(desc);
		int i = 1;
		// ArrayList<ArrayList<String>> starting_hand = combo_hands_1.get_starting_hands();
		// String tuner = "Lamia";
		// for (myFunc combo_line : combo_hands_1.get_lamia_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Ghost";
		// for (myFunc combo_line : combo_hands_1.get_ghost_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Nighthowl";
		// for (myFunc combo_line : combo_hands_1.get_nighthowl_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		// tuner = "Orthros";
		// for (myFunc combo_line : combo_hands_1.get_orthros_lines()) {
		// 	String desc_cl = "Combo Line " + i + " (" + tuner + ")";
		// 	ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
		// 	csc.add_combo_category(cl);
		// 	i += 1;
		// }
		return csc;
	}

	public static ArrayList<ComboSubCategory> get_combo_subcategories(LinkedHashMap<Integer, JSONObject> db_main) {
		return new ArrayList<>(Arrays.asList(csc1(), csc2()
				// , csc3()
		));
	}
}
