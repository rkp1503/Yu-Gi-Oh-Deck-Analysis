package Archetypes.DD.anime_combos.kings;

import YuGiOh.ComboLine;
import YuGiOh.ComboSubCategory;
import YuGiOh.myFunc;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class get_combos_kings {
	private static ComboSubCategory csc1() {
		String desc = "Kepler + 2 of [Swirl/Copernicus/Gryphon]";
		ComboSubCategory csc = new ComboSubCategory(desc);
		int i = 1;
		ArrayList<ArrayList<String>> starting_hand = combo_hands_1.get_starting_hands();
		String tuner = "Lamia";
		for (myFunc combo_line : combo_hands_1.get_lamia_lines()) {
			String desc_cl = "Combo Line " + i + " (" + tuner + ")";
			ComboLine cl = new ComboLine(combo_line, desc_cl, starting_hand);
			csc.add_combo_category(cl);
			i += 1;
		}
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
	public static ArrayList<ComboSubCategory> get_combo_subcategories(LinkedHashMap<Integer, JSONObject> db_main){
		ArrayList<ComboSubCategory> csc_lst = new ArrayList<>();
		csc_lst.add(csc1());
		return csc_lst;
	}
}
