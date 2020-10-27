package com.bridgelabz.gamblingsimulation;

import java.util.Arrays;
import java.util.Random;

public class GamblingSimulation
{
	static int Stake = 100;
	static int Bet = 1;
	static float stake_value = 0.5f;
	public static final int WIN = 1;
	static int win[] = new int[30];
	static int loss[] = new int[30];
	static int winCount = 0, loseCount = 0;
	
	public void betDays()
	{
		int day = 0, i = 0; 
		int winningAmount = 0, losingAmount = 0;
		while(day < 30 && i < 30)
		{
			int winamount, lossamount;
			day++;
			Stake = Stake-Bet;
			Random random = new Random();
			int betCheck = random.nextInt(2);
			int betAmount = (int) (Stake * stake_value);
			if(Stake > 0)
			{
				if(betCheck == WIN)
				{
					Stake = Stake + betAmount + ( 2 * Bet );
					System.out.println("\nGambler won the bet");
					System.out.println("Money left with Gambler: "+Stake);
					winningAmount = winningAmount + betAmount + (2 * Bet);
					winCount++;
					winamount = ( betAmount + ( 2 * Bet ) );
					win[i] = winamount;
					System.out.println("amount won on Day "+day+" is: "+win[i]);
					i++;
				}
				else
				{
					Stake = Stake - betAmount;
					System.out.println("\nGambler lost the bet");
					System.out.println("Money left with Gambler: "+Stake);
					losingAmount = losingAmount + betAmount + Bet;
					loseCount++;
					lossamount = betAmount + Bet;
					loss[i] = lossamount;
					System.out.println("amount lost on Day "+day+" is: "+loss[i]);
					i++;
				}
				System.out.println("Amount for betting on Day "+day+" is: "+betAmount);
				System.out.println("Total amount won by Gambler: "+winningAmount);
				System.out.println("Total amount lost by Gambler: "+losingAmount);
				
				System.out.println("Total number of wins by Gambler: "+winCount);
				System.out.println("Total number of loses by Gambler: "+loseCount);
				
			}
			else
			{
				System.out.println("\nCannot play..., no money left to bet on Day "+day);
				System.out.println("Total amount won by Gambler: "+winningAmount);
				System.out.println("Total amount lost by Gambler: "+losingAmount);
				System.out.println("Total number of wins by Gambler: "+winCount);
				System.out.println("Total number of loses by Gambler: "+loseCount);
			}
		}
		System.out.println("winning amounts: "+Arrays.toString(win));
		System.out.println("losing amounts: "+Arrays.toString(loss));
	}
		
	public void maxAmount()
	{
		int winmax = 0, lossmax = 0;
		int windayCount = 0, lossdayCount = 0;
		for(int counter=0;counter<win.length;counter++)
		{
			if(win[counter]>winmax)
			{
				winmax = win[counter];
				windayCount = counter + 1;
			}
		}
		System.out.println("maxmimun amount "+winmax+" is won on Day "+windayCount);
		System.out.println("Lucky day: "+windayCount);
		for(int counter=0;counter<loss.length;counter++)
		{
			if(loss[counter]>lossmax)
			{
				lossmax = loss[counter];
				lossdayCount = counter + 1;
			}
		}
		System.out.println("maxmimun amount "+lossmax+" is lost on Day "+lossdayCount);
		System.out.println("Un-Lucky day: "+lossdayCount);
	}
	
	public void playGame()
	{
		betDays();
		maxAmount();
	}
	
	public static void main(String[] args)
	{
		int play = 1;
		System.out.println("Welcome to Gambling Simulation Project");
		System.out.println("Gambler started with "+Stake+" rupees");
		GamblingSimulation gamble = new GamblingSimulation();
		gamble.playGame();
		Random random = new Random();
		int playChoice = random.nextInt(2);
		if(playChoice == play)
		{
			System.out.println("You won! Continue to play");
			gamble.playGame();
		}
		else
		{
			System.out.println("You lost");
		}
		System.out.println("Game over");
	}
	
}
