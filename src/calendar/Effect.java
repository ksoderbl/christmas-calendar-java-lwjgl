package calendar;

public interface Effect {
	public void init();
	public void mouse();
	public void keyboard();
	public void reshape(int width, int height);
	public void display();
}
