package com.bridgelabz.gamblingsimulation;

import java.util.Random;

public class GamblingSimulation
{
	static int Stake = 100;
	static int Bet = 1;
	static float stake_value = 0.5f;
	public static final int WIN = 1;
	static int winCount = 0, loseCount = 0;
	
	public void betDays()
	{
		int day = 0, winningAmount = 0, losingAmount = 0;
		while(day < 30)
		{
			day++;
			Stake = Stake-Bet;
			Random random = new Random();
			int betCheck = random.nextInt(2);
			if(Stake > 0)
			{
				int betAmount = (int) (Stake * stake_value);
				if(betCheck == WIN)
				{
					Stake = Stake + betAmount + ( 2 * Bet );
					System.out.println("\nGambler won the bet");
					System.out.println("Money left with Gambler: "+Stake);
					winningAmount = winningAmount + betAmount + (2 * Bet);
					winCount++;
				}
				else
				{
					Stake = Stake - betAmount;
					System.out.println("\nGambler lost the bet");
					System.out.println("Money left with Gambler: "+Stake);
					losingAmount = losingAmount + betAmount + Bet;
					loseCount++;
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
	}
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Gambling Simulation Project");
		System.out.println("Gambler started with "+Stake+" rupees");
		GamblingSimulation gamble = new GamblingSimulation();
		gamble.betDays();
	}
	
}
