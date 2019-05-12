/**
 * 
 */
package business.action;

/**
 * @author Martin Dostal
 * State containing basic state definition and appropriate activities
 */
public abstract class State {

	protected StateEnum state;
	
	/**
	 * Constructor with specific state enumeration type
	 * @param state State Enumeration of this state
	 */
	public State(StateEnum state) {
		this.state = state;
	}

	public StateEnum getStateEnum() {
		return state;
	}
}
