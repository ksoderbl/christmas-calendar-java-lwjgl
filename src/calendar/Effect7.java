package calendar;

public class Effect7 implements Effect {
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
        Effect7 effect = new Effect7();
        Main.runSingleEffect(effect);
    }
}
