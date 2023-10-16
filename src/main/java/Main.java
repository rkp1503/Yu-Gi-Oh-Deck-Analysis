/**
 * Author: Rayla Kurosaki
 * GitHub: https://github.com/rkp1503
 * Working Directory:
 * Command:
 */

import YuGiOh.Deck;
import Archetypes.DD.combos_dd;
import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Main {
	// static final int TEST_HANDS = 10_000_000; // Accuracy level: xx.xy%
	// static final int TEST_HANDS = 1_000_000; // Accuracy level: xx.yy%
	static final int TEST_HANDS = 10_000;
	private static LinkedHashMap<Integer, JSONObject> get_database() throws IOException, JSONException {
		LinkedHashMap<Integer, JSONObject> database = new LinkedHashMap<>();
		String path_to_db = System.getProperty("user.dir") + "/src/main/resources/database.json";
		File database_file = new File(path_to_db);
		if (database_file.exists()) {
			FileInputStream stream = new FileInputStream(path_to_db);
			JSONObject db_json = new JSONObject(IOUtils.toString(stream));
			var keys = db_json.keys();
			while (keys.hasNext()) {
				String key = keys.next().toString();
				database.put(Integer.parseInt(key), db_json.getJSONObject(key));
			}
		}
		return database;
	}

	private static Deck create_deck(String path_to_deck, LinkedHashMap<Integer, JSONObject> database) throws IOException, JSONException {
		String website = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
		Deck deck = new Deck();
		String deck_type = "";
		boolean database_updated = false;
		File deck_file = new File(path_to_deck);
		Scanner scanner = new Scanner(deck_file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains("!side")) {
				deck_type = "Side Deck";
			} else if (line.contains("#extra")) {
				deck_type = "Extra Deck";
			} else if (line.contains("#main")) {
				deck_type = "Main Deck";
			} else if (!line.contains("#created by")) {
				Integer card_id = Integer.parseInt(line);
				if (!database.containsKey(card_id)) {
					URL url = new URL(website + "?id=" + card_id);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					InputStream responseStream = connection.getInputStream();
					JSONObject json_entry = new JSONObject(IOUtils.toString(responseStream));
					JSONArray json_array = json_entry.getJSONArray("data");
					JSONObject card_data = new JSONObject(String.valueOf(json_array.get(0)));
					database.put(card_id, card_data);
					database_updated = true;
				}
				String card_name = (database.get(card_id)).get("name").toString();
				switch (deck_type) {
					case "Main Deck" -> deck.add_card_to_main_deck(card_name);
					case "Extra Deck" -> deck.add_card_to_extra_deck(card_name);
					default -> deck.add_card_to_side_deck(card_name);
				}
			}
		}
		if (database_updated) {
			String path_to_db = System.getProperty("user.dir") + "/src/main/resources/database.json";
			File database_file = new File(path_to_db);
			FileWriter file_writer = new FileWriter(database_file, false);
			JSONObject database_json = new JSONObject(database);
			file_writer.write(database_json.toString(4));
			file_writer.close();
		}
		return deck;
	}

	private static LinkedHashMap<String, Integer> get_database_bridge(LinkedHashMap<Integer, JSONObject> database) throws JSONException {
		LinkedHashMap<String, Integer> database_bridge = new LinkedHashMap<>();
		for (Integer ID : database.keySet()) {
			database_bridge.put(database.get(ID).get("name").toString(), ID);
		}
		return database_bridge;
	}

	public static void main(String[] args) throws JSONException, IOException {
		// Terminates the program if the user has not provided any arguments
		if (args.length < 1) {
			System.out.println("User failed to provide a deck.\nTerminating Program...");
			System.exit(0);
		}
		// Terminates the program if the user has not given a deck to analyze
		if (!args[0].endsWith(".ydk")) {
			System.out.println("File extension error.\nA valid deck must end with the file extension '.ydk'...\nTerminating Program...");
			System.exit(0);
		}
		// Terminates the program if the deck to analyze does not exist
		String deck_filename = args[0];
		String path_to_deck = System.getProperty("user.dir") + "/src/main/resources/decks/" + deck_filename;
		File deck_file = new File(path_to_deck);
		if (!deck_file.exists()) {
			System.out.println("Deck '" + deck_filename + "' does not exist...\nPlease place the deck in the 'src/main/resources/decks' directory.");
			System.exit(0);
		}
		// Get the local database
		LinkedHashMap<Integer, JSONObject> database = get_database();
		// Create the deck
		Deck deck = create_deck(path_to_deck, database);
		LinkedHashMap<String, Integer> database_helper = get_database_bridge(database);
		// Add all relevant combos
		combos_dd.add_anime_combos(deck, database);
		// Analyze the deck
		double time_start = System.currentTimeMillis() / 1000.0;
		deck.analyze(TEST_HANDS, database, database_helper);
		double time_end = System.currentTimeMillis() / 1000.0;
		// Print the results
		deck.print_analysis(TEST_HANDS, 3, time_end - time_start);
	}
}