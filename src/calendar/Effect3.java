package calendar;

public class Effect3 implements Effect {
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
    	return "Objects";
    }
    
    public static void main(String[] args) {
        Effect3 effect = new Effect3();
        Main.runSingleEffect(effect);
    }
}
