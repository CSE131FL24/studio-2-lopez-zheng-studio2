package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double startAmount = in.nextDouble();
		double a=startAmount;
		double winChance = in.nextDouble();
		double winLimit = in.nextDouble();
		int totalSimulations = in.nextInt();
		double ruinDays=0;
		double expectedRuin;
		double alpha=(1-winChance)/winChance;

		boolean stillPlaying = true;
		if(winChance==0.5) {
			expectedRuin=(1-startAmount)/winLimit;
		}
		else {
			expectedRuin= (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
			
		}
		for (int i = 1; i <= totalSimulations; i++) {
			stillPlaying = true;
			int win = 0, lose = 0;
			
			String result = null;
			startAmount=a;
			while (stillPlaying) {
				if (Math.random() <= winChance) {
					// System.out.println("win");
					win++;
					startAmount += 1;
				} else {
					// System.out.println("lose");
					lose++;
					startAmount -= 1;
				}
				if (startAmount >= winLimit) {
					stillPlaying = false;
					result = "successful day";
				}
				if (startAmount <= 0) {
					stillPlaying = false;
					result = "ruin";
					ruinDays++;
				}
				

			}int simulatedPlays = win + lose;
			System.out.println("number of plays: " + simulatedPlays);
			System.out.println(result);
		}
		System.out.println("Simulated days: " + totalSimulations);
		System.out.println("ruin percentage: "+ruinDays/totalSimulations*100+"%");
		System.out.println("expected ruins: "+expectedRuin);

	}

}
