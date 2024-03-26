/*
 * Class: CMSC203 30339
 * Instructor: Grinberg
 * Description: Write an application that lets the user create a management company and add the properties managed by the company to its list 
 * Due: 3/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/
package com.p;


public class Plot extends Object {
	
	private int x;
	private int y;
	private int width;
	private int depth;

	Plot() {
		this(0,0,1,1);
	}
	Plot(int x, int y, int width,int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
	}
	Plot(Plot otherPlot) {
		this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = x;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
    public boolean overlaps(Plot plot) {
    	return (x < plot.x + plot.width && x + width > plot.x &&
                y < plot.y + plot.depth && y + depth > plot.y);
    }
    
    public boolean encompasses(Plot plot) {
        return (x <= plot.x && x + width >= plot.x + plot.width &&
                y <= plot.y && y + depth >= plot.y + plot.depth);
    }

    
	@Override
	public String toString() {
        return x + "," + y + "," + width + "," + depth;

	}
	
}
