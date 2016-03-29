package math;

public class Vector3f {

	public float x, y, z;
	
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3f(){
		this.x = 1.0f;
		this.y = 1.0f;
		this.z = 1.0f;
	}

	public void set(float r, float g, float b) {
		this.x = r;
		this.y = g;
		this.z = b;
		
	}
	
}
