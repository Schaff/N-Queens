import java.util.LinkedList;
import java.util.List;


public class QueenState implements State {
	private int[] _queenLocations; //using an int array to represent the board, with indices as columns and values as rows
	private int _size; //size of array
	private String[][] _conflicts; //used in printed grid when solution is found

	public QueenState(int[] locations, int size) {
		_queenLocations = locations;
		_size = size;
		_conflicts = new String[size][size];
	}

	public String[][] gridLocations() { //used in QueenPane to get the locations of all the queens
		for (int i = 0; i < _size; i++)
			_conflicts[i][_queenLocations[i]] = "Q";
		return _conflicts;
	}

	@Override
	public List<String> actions() {//returns a list of possible locations to move each queen in a column
		List<String> actions = new LinkedList<String>();
		for (int i = 0; i < _size; i++) {// i is a column
			for (int j = 0; j < _size; j++) {//j is each location available to the queen within its column
				if (_queenLocations[i]!=j) {//for every column, move the queen to somewhere that it isn't
					String action = ((Integer) i).toString() + " " + ((Integer) j).toString();
					actions.add(action);
				}
			}
		}
		return actions;
	}

	@Override
	public State successor(String action) {
		String[] hereToThere = action.split(" "); //parses action to find i and j from actions()
		String here = hereToThere[0]; //String i
		String there = hereToThere[1]; //String j
		int index = Integer.parseInt(here);//int i
		int newPosition = Integer.parseInt(there);//int j
		int[] locations = new int[_size];
		for (int i = 0; i < _size; i++) { //copy _queenLocations
			locations[i] = _queenLocations[i];
		}
		locations[index] = newPosition; //change locations based on the received action
		QueenState successor = new QueenState(locations, _size);
		return successor;
	}

	@Override
	public Double estimatedDistance(State s) { //gets number of conflicts on the board, cost = value
		Double conflicts = 0.0;
		for (int column = 0; column < _size - 1; column++) { //optimized enough O(n^2)
			for (int j = 1; j < _size - column; j++) {
				if (_queenLocations[column] == _queenLocations[column+j]) //compare all queens next to current
					conflicts++;
				if (_queenLocations[column] == _queenLocations[column+j]+j) //compare all queens diagonally below
					conflicts++;
				if (_queenLocations[column] == _queenLocations[column+j]-j) //compare all queens diagonally above
					conflicts++;
			}
		}
		return conflicts;
	}
	
	@Override
	public Double stepCost(String action) { //Don't need this function
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object s) { //Don't need this function
		return true;
	}

}
