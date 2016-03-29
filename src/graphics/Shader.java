package graphics;

import java.util.HashMap;
import java.util.Map;

import math.Matrix4f;
import math.Vector3f;
import utils.ShaderUtils;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Shader {

	public static final int VERTEX_ATTRIB = 0;
	public static final int TEXTURE_COORDS_ATTRIB = 1;
	
	private final int ID;	
	private boolean enabled = false;
	
	public static Shader shader1;
	public static Shader fontShader;
	
	public Shader(String vertex, String fragment){
		ID = ShaderUtils.load(vertex, fragment);
	}
	
	public int getUniform(String name){
		return glGetUniformLocation(ID, name);
	}
	
	public static void loadAll(){
		shader1 = new Shader("shaders/shader.vert", "shaders/shader.frag");
		fontShader = new Shader("shaders/font.vert", "shaders/font.frag");
	}
	
	public static void loadShader(String vertShader, String fragShader){
		new Shader(vertShader, fragShader);
	}
	
	public void setUniform1i(String name, int value) {
		if (!enabled) enable();
		glUniform1i(getUniform(name), value);
	}
	
	public void setUniform1f(String name, float value) {
		if (!enabled) enable();
		glUniform1f(getUniform(name), value);
	}
	
	public void setUniform2f(String name, float x, float y) {
		if (!enabled) enable();
		glUniform2f(getUniform(name), x, y);
	}
	
	public void setUniform3f(String name, Vector3f vector) {
		if (!enabled) enable();
		glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
	}
	
	public void setUniformMat4f(String name, Matrix4f matrix) {
		if (!enabled) enable();
		glUniformMatrix4fv(getUniform(name), false, matrix.toFloatBuffer());
	}
	
	public void enable() {
		glUseProgram(ID);
		enabled = true;
	}
	
	public void disable() {
		glUseProgram(0);
		enabled = false;
	}
	
}
