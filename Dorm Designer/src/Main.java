//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dorm Designer 2000
// Files:           DormDesiner.jar
// Course:          CS 300, Summer, 2018
//
// Author:          Jikai Zhang
// Email:           jzhang726@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class Main {
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture furniture[] = new Furniture[6];
	private CreateBedButton bedButton;
	private CreateSofaButton sofaButton;
	
	public static void main(String[] args) {
		Utility.startApplication();
	}
	
	// Constructor of the Main class
	public Main(PApplet processing) {
		this.processing = processing;
		backgroundImage = processing.loadImage("images/background.png");
		this.bedButton  = new CreateBedButton(50, 24, processing);
		this.sofaButton = new CreateSofaButton(150, 24, processing);
	} 
	
	// Update the background image and bedButton and sofaButton image
	public void update() {
		processing.background(95,158,160);
		processing.image(backgroundImage, 
				processing.width/2, processing.height/2);
		bedButton.update();
		sofaButton.update();
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].update();
			}
		}
	}
	
	// Specify the program action when the mouse is pressed
	public void mouseDown() {
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] == null && bedButton.isMouseOver()) {
				furniture[i] = bedButton.mouseDown();
				break;
			} // When the mouse is pressing the bedButton, create a bed
			if (furniture[i] == null && sofaButton.isMouseOver()) {
				furniture[i] = sofaButton.mouseDown();
				break;
			} // When the mouse is pressing the sofaButton, create a sofa
		}
		for (int i = furniture.length - 1; i >= 0; i--) {
			if (furniture[i] != null && furniture[i].isMouseOver()){
				furniture[i].mouseDown();
				break;
			} // When the mouse is pressing 
			  //the furniture(s), move the upper one
		}		 	
	}
		
	// When the mouse is up, give up the control over the furniture
	public void mouseUp() {
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i] != null) {
				furniture[i].mouseUp();
			}
		}
	}
	
	// Specify the action on the furniture when a specific key is pressed
	public void keyPressed() {
		for (int i = 0; i < furniture.length; i++) {
			if (processing.key == 'D' || processing.key == 'd' && 
					furniture[i] != null && furniture[i].isMouseOver()
						) {
				furniture[i] = null;
				break;
			}
		} // When pressing 'D' or 'd', delete the furniture the mouse on
		for (int i = 0; i < furniture.length; i++) {
			if ( processing.key == 'R' || processing.key == 'r' && 
					furniture[i] != null && furniture[i].isMouseOver()) {
				furniture[i].rotate();
				break;
			}
		} // When pressing 'R' or 'r', 
		  // rotate the furniture by 90 degrees, clockwise
	}
}

