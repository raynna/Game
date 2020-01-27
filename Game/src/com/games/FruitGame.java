package com.games;

import java.util.ArrayList;

import com.account.Account;
import com.account.AccountCreation;
import com.utils.Utils;

public class FruitGame extends Game {

	private transient Account account;

	public FruitGame(Account account) {
		super(account);
		this.account = account;
	}

	ArrayList<String> fruits = new ArrayList<>();
	private String[] fruitTypes = { "Orange", "Apple", "Pear" };
	private int FRUIT_AMOUNT = 3;

	public void start(int pot) {
		fruits.clear();
		System.out.println("Total pot: " + pot);
		account.removeCoins(pot);
		for (int i = 0; i < FRUIT_AMOUNT; i++) {
			fruits.add(fruitTypes[Utils.getRandom(fruitTypes.length - 1)]);
			System.out.println("Fruit " + (i + 1) + ": " + fruits.get(i));
			try {
				if (i != FRUIT_AMOUNT - 1)
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		boolean win = true;
		for (int i = 0; i < fruits.size() - 1; i++) {
			if (fruits.get(i) != fruits.get(i + 1))
				win = false;
		}
		int winnings;
		if (win) {
			winnings = pot + pot * FRUIT_AMOUNT;
			account.setCoins(winnings, true);
			System.out.println("You win a total of " + winnings + " coins.");
		} else
			System.out.println("You lost!");
		System.out.println("You have a total of " + account.getCoins() + " coins left.");
		AccountCreation.savePlayer(account);
	}
}
