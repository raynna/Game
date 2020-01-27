package com;

import com.account.Account;
import com.account.AccountCreation;
import com.games.Game;

public class Launcher {

	public static void main(String[] args) throws Exception {
		String name = "andreas";
		Account account = AccountCreation.exists(name) ? AccountCreation.loadPlayer(name) : (new Account(name));
		account.init();
		Game game = account.getGames().getName("fruit");
		game.start(game);
	}

}
