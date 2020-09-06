package calendar;

public class CalendarEffect implements Effect {
	
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
    	return "Christmas calendar";
    }
	
    public static void main(String[] args) {
        CalendarEffect effect = new CalendarEffect();
        Main.runSingleEffect(effect);
    }
}
