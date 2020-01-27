package com.games;

import com.account.Account;

public class Game {

	private Account account;

	public Game(Account account) {
		this.account = account;
	}

	public Game getName(String name) {
		Game game = null;
		if (name.contains("fruit"))
			game = new FruitGame(account);
		return game;
	}

	public void start(Game game) {
		if (game instanceof FruitGame) {
			FruitGame g = (FruitGame) game;
			g.start(50);
		}

	}

}
