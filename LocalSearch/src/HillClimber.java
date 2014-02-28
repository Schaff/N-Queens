import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class HillClimber {

	private LocalSearchNode _current;
	private int _shoulderSearchStepsAllowed;
	private double _capacity;
	private Grid _grid;
	private int _size;


	public HillClimber(LocalSearchNode initial, int searchShoulder, double capacity, Grid grid, int size){
		_current = initial;
		_shoulderSearchStepsAllowed = searchShoulder;
		_capacity = capacity;
		_grid = grid;
		_size = size;
	}

	public LocalSearchNode findSolution() {
		State neighborState;
		int shoulderSteps = 0; //sideways steps
		while (true) {
			_grid.setFrame(_size, _current.getState(), Color.GRAY);
			if (shoulderSteps > _shoulderSearchStepsAllowed) { //restart if number of steps allowed is exceeded
				return null;
			}
			if (_current.getValue() == 0.0) { //solution condition, value is really cost
				System.out.println("Solution!");
				_grid.setFrame(_size, _current.getState(), Color.BLUE);
				return _current;
			}
			else {
				List<LocalSearchNode> bestNodes = new LinkedList<LocalSearchNode>();
				LocalSearchNode bestNode = new LocalSearchNode(null, null, _capacity, shoulderSteps); //arbitrary starting node that will be running best
				for (String s : _current.getState().actions()) {//goes through every possible move and sets bestNode to be one with the least amount of conflicts
					neighborState = _current.getState().successor(s);
					double value = neighborState.estimatedDistance(null);//estimated distance calculates number of conflicts
					if (bestNode.getValue() >= value) {//if the neighbor has less conflicts, make it the new best
						bestNode = new LocalSearchNode(neighborState, s, value, _current.getSteps()+1);
					}
				}
				if (bestNode.getValue().equals(_current.getValue())) {// if the best was a shoulder step, choose randomly from the available shoulder successors
					int counter = 0;
					for (String s: _current.getState().actions()) {
						neighborState = _current.getState().successor(s);
						double value = neighborState.estimatedDistance(null);
						if (bestNode.getValue() == value) {
							bestNodes.add(new LocalSearchNode(neighborState, s, value, _current.getSteps()+1)); //put the shoulders in a list
							counter++;
						}
					}
					_current = bestNodes.get((int)(counter * Math.random())); //pick one randomly
					_grid.setFrame(_size, _current.getState(), Color.RED); //flash red to designate a shoulder step
					shoulderSteps++; //increment the counter, to check for exceeding the allowable shoulder moves
				}
				else { 
					shoulderSteps = 0;//otherwise restart the counter
					_current = bestNode; //the current is now current's best successor
				}
			}
		}
	}


}
