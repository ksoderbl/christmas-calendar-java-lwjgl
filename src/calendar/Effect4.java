package calendar;

public class Effect4 implements Effect {
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
    	return "Ball";
    }
	
    public static void main(String[] args) {
        Effect4 effect = new Effect4();
        Main.runSingleEffect(effect);
    }
}
