package calendar;

public class Effect12 implements Effect {
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
        Effect12 effect = new Effect12();
        Main.runSingleEffect(effect);
    }
}
