package game;

import graphics.Shader;
import math.Matrix4f;
import math.Vector3f;


public class Camera {

	Matrix4f projMatrix = new Matrix4f();
    Matrix4f viewMatrix = new Matrix4f();
    
    Vector3f position = new Vector3f();
	
    public Camera(){
    	Matrix4f pr_matrix = Matrix4f.perspective(10.0f, 10.0f, 10.0f, 10.0f, -1.0f, 100.0f, 15.0f, (float)800/(float)600);
		Shader.shader1.enable();
		Shader.shader1.setUniformMat4f("vw_matrix", Matrix4f.translate(position));		
		Shader.shader1.setUniformMat4f("pr_matrix", pr_matrix);
		Shader.shader1.disable();
    }
    
    public Matrix4f getProjMatrix() {
		return projMatrix;
	}

	public Matrix4f getViewMatrix() {
		return viewMatrix;
	}

	public Vector3f getPosition() {
		return position;
	}    
	
	
}
