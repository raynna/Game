package com.account;

import com.games.Game;

public class Account {

	private String name;
	private int coins;

	private transient Game game;

	public void init() {
		if (game == null)
			game = new Game(this);
	}

	public Account(String name) {
		this.name = name;
		if (game == null) {
			game = new Game(this);
		}
	}

	public Game getGames() {
		return game;
	}

	public String getName() {
		return name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int value, boolean add) {
		this.coins = add ? (getCoins() + value) : value;
	}

	public void removeCoins(int value) {
		setCoins(getCoins() - value, false);
	}
}
