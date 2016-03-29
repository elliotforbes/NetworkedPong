package userinterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import graphics.Shader;
import graphics.VertexArrayObject;

public class FontRenderer {
	
	private float[] vertices;
	private float[] texCoords;

	private VertexArrayObject vao;
	
	public FontRenderer(){
		vao = new VertexArrayObject(generateVertexList(vertices), generateTexCoordsList(texCoords));
	}
	
	private float[] generateTexCoordsList(float[] texCoords) {	
		return null;
	}

	private float[] generateVertexList(float[] vertices) {
		return null;
	}

	public FontRenderer(File atlas) {
	}
	
	public void render(){
		Shader.fontShader.enable();
		vao.render();
		Shader.fontShader.disable();
	}
	

}
