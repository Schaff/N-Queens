import java.util.Scanner;


public class SearchProgram {

	public static void main(String[] args) {
		LocalSearchNode answer = null;
		int attempts = 0;

		//take input
		System.out.println("N x N Queen Problem\n" + "Enter N:");

		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();

//		System.out.println("Enter number of shoulder steps allowed:");
//		int k = reader.nextInt();

		int k = 100;
		int[] array = new int[n]; //using an int array to represent the board, with indices as columns and values as rows
		for(int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * n); // randomly generates board state for given size
		}
		QueenState initialState = new QueenState(array, n);
		double cap = initialState.estimatedDistance(null); // used as an upper limit in HillClimber
		Grid grid = new Grid(n, initialState);
		
		while(answer == null) { //this loop repeats the hill climbing algorithm until a solution is reached

			HillClimber solution = new HillClimber(new LocalSearchNode(initialState, "start", cap, 0), k, cap, grid, n);
			answer = solution.findSolution();
			attempts++; //counter to print number of times board had to be reset
			for(int i = 0; i < n; i++) {
				array[i] = (int) (Math.random() * n); // randomly generates board state for given size
			}
			initialState = new QueenState(array, n);
			cap = initialState.estimatedDistance(null); // used as an upper limit in HillClimber
		}
		System.out.println("N:" + n);
		System.out.println("Number of Shoulders allowed: " + k);
		System.out.println("Number of Attempts: " + attempts);
		System.out.println("Number of Steps: " + answer.getSteps());
		
		
	}

}
