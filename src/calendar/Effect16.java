package calendar;

public class Effect16 implements Effect {
	public void init() {
		
	}
	
	public void mouse() {
		
	}
	
	public void keyboard() {
		
	}
	
	public void reshape(int width, int height) {
		
	}
	
	public void display() {
		
	}

	public String getName() {
    	return "\"Brownian\" motion";
    }

	public static void main(String[] args) {
        Effect16 effect = new Effect16();
        Main.runSingleEffect(effect);
    }
}
