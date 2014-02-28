import java.util.List;

public interface State {
	List<String> actions(); // possible actions while in this state
	State successor(String action);  
	Double stepCost(String action);
	boolean equals(Object s);
	Double estimatedDistance(State s);  // estimated distance between state and another state, usually used with goal state
}
