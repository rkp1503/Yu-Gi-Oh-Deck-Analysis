/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 */
package Archetypes.DD;

import Archetypes.DD.anime_combos.kings.get_combos_kings;
import YuGiOh.ComboCategory;
import YuGiOh.ComboSubCategory;
import YuGiOh.Deck;
import org.codehaus.jettison.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class combos_dd {
	public static void add_anime_combos(Deck deck, LinkedHashMap<Integer, JSONObject> db_main) {
		ComboCategory t_kings = new ComboCategory("Triple Kings");
		ArrayList<ComboSubCategory> csc_lst = get_combos_kings.get_combo_subcategories(db_main);
		for (ComboSubCategory csc : csc_lst) {
			t_kings.add_combo_category(csc);
		}
		ComboCategory emperors = new ComboCategory("Triple Emperors");
		ComboCategory super_dooms = new ComboCategory("Triple Super Dooms");
		ArrayList<ComboCategory> cc_lst = new ArrayList<>(Arrays.asList(
				t_kings
		));
		for (ComboCategory cc : cc_lst) {
			deck.add_combo_category(cc);
		}
	}

	public static void add_tournament_combos() {
	}
}
