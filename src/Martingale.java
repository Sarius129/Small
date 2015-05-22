import java.util.Random;

public class Martingale {

	static final int FRACTION = 10000;
	static final int INITIAL_BALANCE = 10000000;
	static final int TEST_NUMBER = 1000;
	static final int MULTIPLIER = 2;

	public static void main (String[] args) {
		Random random = new Random();

		int wins = 0;
		int lose = 0;
		double winFactorAverage = 0;


		for (int j = 0; j<TEST_NUMBER; j++) {
			int balance = INITIAL_BALANCE;
			int tradeSize = balance / FRACTION;
			int opSize = tradeSize;
			int biggest = balance;
			for (long i = 0; i<100L; i++) {
				if (opSize > balance) opSize = balance;
				if (random.nextInt(2) == 1) {
					int change = opSize;
					balance += change;
					//					System.out.printf("#%d balance: %d +%d\n", i, balance, opSize);
					opSize = tradeSize;
					biggest = balance;
				}
				else {
					int change = -opSize;
					balance += change;
					//					System.out.printf("#%d balance: %d -%d\n", i, balance, opSize);
					opSize *= MULTIPLIER;
				}
				if (balance <= 0) break;
				tradeSize = balance / FRACTION;
				//				System.out.println("growth factor: " + (double)biggest / INITIAL_BALANCE);
				//				System.out.println("final factor : " + (double)balance / INITIAL_BALANCE);
			}
			if (balance > INITIAL_BALANCE) {
				wins++;
				double finalFactor = (double)balance / INITIAL_BALANCE;
				winFactorAverage += finalFactor;
			}
			else lose++;
		}
		winFactorAverage /= wins;

		double winLoseRatio = (double) wins / lose;
		double winRatio = (double) wins / TEST_NUMBER;
		double multiplication = winRatio * winFactorAverage;

		System.out.printf("win-lose ratio: %.3f\nwin ratio:%.3f\nwin factor: %.3f",
				winLoseRatio, winRatio, winFactorAverage);
		System.out.printf("\nmultiplication:%.3f", multiplication);

	}
}