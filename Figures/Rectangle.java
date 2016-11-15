package Figures;

public class Rectangle extends Figure {
	private double height, width;

	public Rectangle(int h, int w) {
		height = h;
		width = w;
	}

	public double getS() {
		return height * width;
	}

	public void drawRectangle(char height, char width) {
		if ((height <= 0) && (width <= 0)) {
			System.out.println("Error input data on the long side");
			return;
		}
		char hline = '-';
		char space = ' ';
		char vline = '|';
		for (char i = 0; i < height; i++) {
			System.out.print(vline);
			for (char j = 0; j < width; j++) {
				if ((i == 0 || i == height-1)) {
					System.out.print(hline);
				} else {
					System.out.print(space);
				}
			}
			System.out.print(vline);
			System.out.println();
		}

	}

}
