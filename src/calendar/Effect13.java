package calendar;

public class Effect13 implements Effect {
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
    	return "Stars only";
    }
	
    public static void main(String[] args) {
        Effect13 effect = new Effect13();
        Main.runSingleEffect(effect);
    }
}
