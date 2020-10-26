package com.bridgelabz.gamblingsimulation;

import java.util.Random;

public class GamblingSimulation
{
	static int Stake = 100;
	static int Bet = 1;
	public static final int WIN = 1;
	
	public void bet()
	{
		Stake = Stake-Bet;
		Random random = new Random();
		int betCheck = random.nextInt(2);
		if(betCheck == WIN)
		{
			Stake = Stake+2;
			System.out.println("Gambler won");
			System.out.println("Money left with Gambler: "+Stake);
		}
		else
		{
			System.out.println("Gambler lost");
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
