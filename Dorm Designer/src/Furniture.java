
public class Furniture {
	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	
	// initializes the fields of a new bed object 
	// positioned in the center of the display
	public Furniture(String type, PApplet processing) { 
		this.processing = processing;
		this.isDragging = false;
		image = processing.loadImage("images/" + type + ".png");
		position = new float [] {processing.width/2, 
			processing.height/2};
	}
	
	
	// draws this bed at its current position
	public void update() { 
		processing.image(image, position[0], position[1], rotations*PApplet.PI/2);
		if (isDragging) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;
		}
	}
	
	// used to start dragging the bed, 
	// when the mouse is over this bed when it is pressed
	public void mouseDown() { 
		isDragging = isMouseOver();
	}
	
	// used to indicate that the bed is no longer being dragged
	public void mouseUp() { 
		isDragging = false;
	}
	
	// helper method to determine whether the mouse is currently over this bed
	public boolean isMouseOver() { 
		if (rotations % 2 == 0) {
			if (position[0] - image.width/2 <= processing.mouseX && 
					processing.mouseX <= position[0] + image.width/2 && 
					position[1] - image.height/2 <= processing.mouseY && 
					processing.mouseY <= position[1] + image.height/2) {
				return true;
			}
		}
		else {
			if (position[0] - image.height/2 <= processing.mouseX && 
					processing.mouseX <= position[0] + image.height/2 && 
					position[1] - image.width/2 <= processing.mouseY && 
					processing.mouseY <= position[1] + image.width/2) {
				return true;
			}
		}
		return false;
		
	}
	
	// Increase the field of rotations by 1 
	// each time the key 'R' or 'r' is pressed
	public void rotate() { 
		rotations = rotations + 1;
	}
	
	// Get the rotations value
	public int getRotation() {
		return rotations;
	}
}
