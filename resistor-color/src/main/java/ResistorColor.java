class ResistorColor {
    int colorCode(String color) {
        switch (color) {
		case "black":
			return 0;
		case "white":
			return 9;
		case "orange":
			return 3;

		}
		return 0;
    }

    String[] colors() {
        String[] colors = new String[10];
		colors[0] = "black";
		colors[1] = "brown";
		colors[2] = "red";
		colors[3] = "orange";
		colors[4] = "yellow";
		colors[5] = "green";
		colors[6] = "blue";
		colors[7] = "violet";
		colors[8] = "grey";
		colors[9] = "white";
		
		return colors;
    }
}
