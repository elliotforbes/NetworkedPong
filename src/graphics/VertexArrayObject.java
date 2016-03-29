package graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

import utils.Utilities;

public class VertexArrayObject {
	
	private int VAO, VBO, IBO, TCBO;
	
	private int count;
	private int vertex_count;
	
	public VertexArrayObject(float[] vertices, float[] texCoords){
		VAO = glGenVertexArrays();
		glBindVertexArray(VAO);
		
		VBO = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, VBO);
		glBufferData(GL_ARRAY_BUFFER, Utilities.createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.VERTEX_ATTRIB, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		
		TCBO = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, TCBO);
		glBufferData(GL_ARRAY_BUFFER, Utilities.createFloatBuffer(texCoords), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.TEXTURE_COORDS_ATTRIB, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(Shader.TEXTURE_COORDS_ATTRIB);
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	
	}
	
	public VertexArrayObject(float[] vertices, int[] indices, float[] texCoords){
		
		count = indices.length;
		vertex_count = vertices.length;
		
		VAO = glGenVertexArrays();
		glBindVertexArray(VAO);
		
		IBO = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);
		IntBuffer indicesBuffer = createIntBuffer(indices);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
		
		VBO = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, VBO);
		glBufferData(GL_ARRAY_BUFFER, Utilities.createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
	
		
		TCBO = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, TCBO);
		glBufferData(GL_ARRAY_BUFFER, Utilities.createFloatBuffer(texCoords), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.TEXTURE_COORDS_ATTRIB, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(Shader.TEXTURE_COORDS_ATTRIB);
		
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	private IntBuffer createIntBuffer(int[] indices){
		IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);
		buffer.put(indices);
		buffer.flip();
		return buffer;
	}
	
	public void bind(){
		glBindVertexArray(VAO);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, IBO);
	}
	
	public void unbind(){
		glBindVertexArray(0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
	public void draw(){
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_INT, 0);
	}
	
	public void render(){
		bind();
		draw();
	}

}
