package game;

import graphics.Shader;
import graphics.Texture;
import graphics.VertexArrayObject;
import math.Matrix4f;
import math.Vector3f;

public class Background {
public Vector3f position;
	
	private String texPath = "textures/pong_bg.png";
	private VertexArrayObject vao;
	private Texture tex;
	
	static float[] vertices = {			
			-2.0f,2.0f,-0.015f,	
			-2.0f,-2.0f,-0.015f,	
			2.0f,-2.0f,-0.015f,	
			2.0f,2.0f,-0.015f,		
			
			-2.0f,2.0f,0.015f,	
			-2.0f,-2.0f,0.015f,	
			2.0f,-2.0f,0.015f,	
			2.0f,2.0f,0.015f,
			
			2.0f,2.0f,-0.015f,	
			2.0f,-2.0f,-0.015f,	
			2.0f,-2.0f,0.015f,	
			2.0f,2.0f,0.015f,
			
			-2.0f,2.0f,-0.015f,	
			-2.0f,-2.0f,-0.015f,	
			-2.0f,-2.0f,0.015f,	
			-2.0f,2.0f,0.015f,
			
			-2.0f,2.0f,0.015f,
			-2.0f,2.0f,-0.015f,
			2.0f,2.0f,-0.015f,
			2.0f,2.0f,0.015f,
			
			-2.0f,-2.0f,0.015f,
			-2.0f,-2.0f,-0.015f,
			2.0f,-2.0f,-0.015f,
			2.0f,-2.0f,0.015f
			
	};
	
	static float[] texCoords = {
			
			0,0,
			0,1,
			1,1,
			1,0,			
			0,0,
			0,1,
			1,1,
			1,0,			
			0,0,
			0,1,
			1,1,
			1,0,
			0,0,
			0,1,
			1,1,
			1,0,
			0,0,
			0,1,
			1,1,
			1,0,
			0,0,
			0,1,
			1,1,
			1,0

			
	};
	
	static int[] indices = {
			0,1,3,	
			3,1,2,	
			4,5,7,
			7,5,6,
			8,9,11,
			11,9,10,
			12,13,15,
			15,13,14,	
			16,17,19,
			19,17,18,
			20,21,23,
			23,21,22

	};
	
	public Background(){
		position = new Vector3f(0,0,2.0f);
		tex = new Texture(texPath);
		vao = new VertexArrayObject(vertices, indices, texCoords);
	}
	
	
	
	public void render(){
		Shader.shader1.enable();
		Shader.shader1.setUniformMat4f("ml_matrix", Matrix4f.translate(position));
		tex.bind();
		vao.render();
		tex.unbind();
		Shader.shader1.disable();
	}
	
}
