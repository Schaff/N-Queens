/* A fairly minimal container for Local Search information
 * 
 */
public class LocalSearchNode{
	private State _state;
	private String _action; 
	private Double _value;  // quality that is to be minimized
	private int _numberOfSteps;  // number of steps in Search, used for analysis
	
	public LocalSearchNode(State state, String action, Double value,int steps) {
		_state = state;
		_action = action;
		_value = value;
		_numberOfSteps = steps;
	}
	
	public State getState() { return _state;}
	public String getAction() {return _action;}
	public Double getValue(){return _value;}
	public int getSteps(){return _numberOfSteps;}
	
	public String toString(){ //unused
		return "<"+_state+", "+ _value+"("+_numberOfSteps+")>";
	}
}