package game;

import org.lwjgl.glfw.GLFW;

import graphics.Shader;
import graphics.Texture;
import graphics.VertexArrayObject;
import input.KeyboardHandler;
import math.Matrix4f;
import math.Vector3f;
import network.NetworkClient;

public class Paddle extends GameObject{
	
	NetworkClient client;
	
	public Paddle(NetworkClient client){
		this.client = client;
		position = new Vector3f(-1.0f, 0.5f, 1.5f);
		tex = new Texture(texPath);
		vao = new VertexArrayObject(vertices, indices, texCoords);
	}
	
	public void setPosition(Vector3f pos){
		this.position = pos;
	}
	
	public void update(){
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_S)){		
			client.sendUpdate();
			this.position.y -= 0.01f;
		}
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_W))
			this.position.y += 0.01f;
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
