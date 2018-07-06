/*
* The Data class represents graphic data objects defined for the DormDesigner Application. 
* A Data object is passed into each of the callback methods
* @author Gary Dahl
* @since February 2018
*/

public class Data {
// Objects of this type Data are just collections of public fields. 
// You can use the dot operator with a reference to one of these objects to access any of these fields by name.

    public PApplet processing; // contains the drawing functionality of the processing library

    // references to images that are loaded in setup() and drawn in update()
    public PImage backgroundImage;
    public PImage bedImage; 

    // 2 dimensional array storing the positions of beds within the current room layout
    // Usage: data.bedPositions[bedIndex][0: x-coordinate, or 1: y-coordinate]
    public float[][] bedPositions; 

    // dragBedIndex field tracks the index within bedPositions of the bed that is being dragged 
    // (or when no bed is being dragged, this index will be -1)
    public int dragBedIndex; 
}
