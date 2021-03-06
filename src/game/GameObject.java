package game;

import graphics.Texture;
import graphics.VertexArrayObject;
import math.Vector3f;
import network.NetworkClient;

public class GameObject {

	public Vector3f position = new Vector3f();
	
	protected String texPath = "textures/paddle.jpg";
	protected VertexArrayObject vao;
	protected Texture tex;
	
	static float[] vertices = {			
			-0.025f,0.15f,-0.015f,	
			-0.025f,-0.15f,-0.015f,	
			0.025f,-0.15f,-0.015f,	
			0.025f,0.15f,-0.015f,		
			
			-0.025f,0.15f,0.015f,	
			-0.025f,-0.15f,0.015f,	
			0.025f,-0.15f,0.015f,	
			0.025f,0.15f,0.015f,
			
			0.025f,0.15f,-0.015f,	
			0.025f,-0.15f,-0.015f,	
			0.025f,-0.15f,0.015f,	
			0.025f,0.15f,0.015f,
			
			-0.025f,0.15f,-0.015f,	
			-0.025f,-0.15f,-0.015f,	
			-0.025f,-0.15f,0.015f,	
			-0.025f,0.15f,0.015f,
			
			-0.025f,0.15f,0.015f,
			-0.025f,0.15f,-0.015f,
			0.025f,0.15f,-0.015f,
			0.025f,0.15f,0.015f,
			
			-0.025f,-0.15f,0.015f,
			-0.025f,-0.15f,-0.015f,
			0.025f,-0.15f,-0.015f,
			0.025f,-0.15f,0.015f
			
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
	
	public GameObject(){
		
	}
	
}
