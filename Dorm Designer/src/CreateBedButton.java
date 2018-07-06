
public class CreateBedButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;

	private PApplet processing;
	private float[] position;
	private String label;
	
	// Create a new bed (with position at the center of the screen)
	public CreateBedButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Create Bed";
	}
	
	// Create the bedButton
	public void update() { 
		if (isMouseOver() == true) {
			processing.fill(100);
		} // Set the color of the button with dark gray
		else {
			processing.fill(200);
		} // Set the color of the button with light gray
		processing.rect(position[0] - WIDTH/2, position[1] + HEIGHT/2, 
				position[0] + WIDTH/2, position[1] - HEIGHT/2);
		// Draw the rectangular button
		processing.fill(0); // Set the color of the button with black
		processing.text(label, position[0], position[1]);
		// Type the name on the button
	}
	
	// Create a new bed when pressing the bedButton
	public Furniture mouseDown() {
		if (isMouseOver()) {
			return new Furniture("bed", processing);
			// When the button is pressed, a new bed should be created
		}
		return null;
	}	
	
	// Determine whether the mouse is over the bedButton
	public boolean isMouseOver() { 
		if (position[0] - WIDTH/2 <= processing.mouseX && 
				processing.mouseX <= position[0] + WIDTH/2 && 
				position[1] - HEIGHT/2 <= processing.mouseY && 
				processing.mouseY <= position[1] + HEIGHT/2) {
			return true;
			// If the mouse is over the button, return true
		}
		return false;
	}	

}
