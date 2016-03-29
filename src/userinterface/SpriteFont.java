package userinterface;

import java.util.ArrayList;
import java.util.List;

import graphics.Shader;
import graphics.VertexArrayObject;
import math.Vector2f;
import math.Vector3f;

public class SpriteFont {

	private float[] vertices;
	private float[] texCoords;
	
	private String textValue;
	private float fontSize;
	
	private VertexArrayObject vao;
	private Vector3f colour = new Vector3f();
	
	private Vector2f position;
	
	private Font font;
	
	public static float lineHeight = 1.0f;
	
	/**
	 * Takes in 4 key parameters and performs all necessary vertex calculations from
	 * there.
	 * 
	 * @param text
	 * @param font
	 * @param position
	 * @param colour
	 */
	public SpriteFont(String text, Font font, Vector2f position, Vector3f colour, float fontSize){
		this.textValue = text;
		this.font = font;
		this.position = position;
		this.colour = colour;
		this.fontSize = fontSize;
		// This will take in list of vertices and texCoords and generate vao
		vao = new VertexArrayObject(getVertices(), getTexCoords());
	}
	
	
	// looks at the file and generates the list of vertices from 
		// that file
		public float[] getVertices() {
			List<Float> vertices = new ArrayList<Float>();
			
			int i = 0;
			for(i = 0; i< textValue.length(); i++){
				float x = position.x;
				float y = position.y;
				float maxX = x + fontSize;
				float maxY = y + fontSize;
				
				float realX = (2 * x) - 1;
				float realY = (-2 * y) + 1;
				float realMaxX = (2 * maxX) - 1;
				float realMaxY = (-2 * maxY) + 1;
				
				vertices.add(realX);
				vertices.add(realY);
				vertices.add(realMaxX);
				vertices.add(realMaxY);
				
			}
			return listToArray(vertices);
		}
		
		// looks at file and generates list of texture coordinates from that
		// file
		public float[] getTexCoords() {
			List<Float> texCoords = new ArrayList<Float>();
			
			int i = 0;
			for(i = 0; i < textValue.length(); i++){
				texCoords.add((float) position.x);
			}
			
			return listToArray(texCoords);
		}

		private static float[] listToArray(List<Float> listOfFloats) {
	        float[] array = new float[listOfFloats.size()];
	        for (int i = 0; i < array.length; i++) {
	            array[i] = listOfFloats.get(i);
	        }
	        return array;
	    }
	
	/**
	 * Renders our font onto the screen using the fontShader
	 */
	public void render(){
		Shader.fontShader.enable();
		// need to pass in colour and position here
		Shader.fontShader.disable();
	}
	
}
