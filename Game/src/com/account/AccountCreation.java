package com.account;

import java.io.File;

import com.json.JSONParser;

public class AccountCreation {

	/**
	 * Load a player saved in json format
	 *
	 * @param username username of the player
	 */
	public static Account loadPlayer(String username) {
		return (Account) JSONParser.load("data/" + username + ".json", Account.class);
	}

	/**
	 * Save this player as json
	 */
	public static void savePlayer(Account player) {
		JSONParser.save(player, "data/" + player.getName() + ".json", Account.class);
	}

	public static boolean exists(String username) {
		return new File("data/" + username + ".json").exists();
	}

}
