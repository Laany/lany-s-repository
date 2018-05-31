package jcdg;

import java.awt.Color;
import java.util.Random;

public class RondomTool {
	public static Color getRandomColor() {
		Random random=new Random();
		int red=random.nextInt(255);
		int blue=random.nextInt(255);
		int green=random.nextInt(255);
		return new Color(red, blue, green);
	}
}