package calendar;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static final int windowWidth = 1080;
	public static final int windowHeight = 720;
	public static final String windowTitle = "Christmas Calendar in Java and LWJGL";
	
	public static List<Effect> effects = new ArrayList<Effect>(); 

    public static void main(String[] args) {
    	Window window = new Window(windowWidth, windowHeight, windowTitle);
    	
    	effects.add(new CalendarEffect());
    	effects.add(new Effect1());
    	effects.add(new Effect2());
    	effects.add(new Effect3());
    	effects.add(new Effect4());
    	effects.add(new Effect5());
    	effects.add(new Effect6());
    	effects.add(new Effect7());
    	effects.add(new Effect8());
    	effects.add(new Effect9());
    	effects.add(new Effect10());
    	effects.add(new Effect11());
    	effects.add(new Effect12());
    	effects.add(new Effect13());
    	effects.add(new Effect14());
    	effects.add(new Effect15());
    	effects.add(new Effect16());
    	effects.add(new Effect17());
    	effects.add(new Effect18());
    	effects.add(new Effect19());
    	effects.add(new Effect20());
    	effects.add(new Effect21());
    	effects.add(new Effect22());
    	effects.add(new Effect23());
    	effects.add(new Effect24());
    	
    	Effect effect = effects.get(1);
        //effect.start();
    }
}
