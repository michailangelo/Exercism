class Darts {
	private double x,y;

    Darts(double x, double y) {
		this.x=x;
		this.y=y;       
    }

    int score() {
		if (x <= 1 && y <= 1)
			return 10;
		if (x <= 5 && y <= 5)
			return 5;
		if (x <= 10 && y <= 10)
			return 1;
		return 0;
    }

}
