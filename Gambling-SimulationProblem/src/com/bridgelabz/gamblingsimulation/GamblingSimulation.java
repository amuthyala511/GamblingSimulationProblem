package com.bridgelabz.gamblingsimulation;

import java.util.Random;

public class GamblingSimulation
{
	static int Stake = 100;
	static int Bet = 1;
	static float stake_value = 0.5f;
	public static final int WIN = 1;
	
	public void bet()
	{
		Stake = Stake-Bet;
		Random random = new Random();
		int betCheck = random.nextInt(2);
		if(betCheck == WIN)
		{
			Stake = (int) (Stake + (Stake * stake_value));
			System.out.println("Gambler won the bet");
			System.out.println("Money left with Gambler: "+Stake);
		}
		else
		{
			Stake = (int) (Stake - (Stake * stake_value));
			System.out.println("Gambler lost the bet");
			System.out.println("Money left with Gambler: "+Stake);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Gambling Simulation Project");
		System.out.println("Gambler started with "+Stake+" rupees");
		GamblingSimulation gamble = new GamblingSimulation();
		gamble.bet();
	}
	
}
