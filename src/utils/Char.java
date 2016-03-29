package utils;

public class Char {

	private float x;
	private float y;
	
	private float width;
	private float height;
	private int id;
	
	public Char(float x, float y, float width, float height){
		
	}

	public Char() {
		// TODO Auto-generated constructor stub
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
}
