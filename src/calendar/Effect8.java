package calendar;

public class Effect8 implements Effect {
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
    	return "Gouraud shaded Icosahedron";
    }
	
    public static void main(String[] args) {
        Effect8 effect = new Effect8();
        Main.runSingleEffect(effect);
    }
}
