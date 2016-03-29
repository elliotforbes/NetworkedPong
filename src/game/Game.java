package game;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import graphics.Shader;
import input.KeyboardHandler;
import math.Vector3f;
import network.NetworkClient;

public class Game {
	
	private enum State {
		MENU, PLAY, PAUSE, MOVIE
	};
	
	private static State gameState;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	Paddle player1;
	Paddle player2;
	
	Background bg;
	
	Camera cam;
	NetworkClient client;
	
	public Game() {
		// loads in our shaders
		Shader.loadAll();
		
		// initializes all of our game objects
		gameState = State.MENU;
		client = new NetworkClient();
		cam = new Camera();
		bg = new Background();
		player1 = new Paddle(client);
		player1.setPosition(new Vector3f(-1.0f, 0.5f, 1.5f));
		
		// starts our network client thread
		init();
	}
	
	public void init() {
		client.start();
	}
	
	public void handleInput(){
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_SPACE)){
			gameState = State.PLAY;
		}
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_P)){
			System.err.println("Pausing Play...");
			gameState = State.PAUSE;
		}
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_R)){
			gameState = State.PLAY;
			System.err.println("Resuming Play...");
		}
		if(KeyboardHandler.isKeyDown(GLFW.GLFW_KEY_ESCAPE)){
			gameState = State.MENU;
		}
	}
	
	public void update() {
		handleInput();
		
		switch(gameState) {
			case MENU:
				// update all menu stuff
				break;
			case PLAY:
				// update our player object and allow us to play
				player1.update();
				break;
				
			case PAUSE:
				// stop updating our game objects and essentially do nothing
				break;
				
			case MOVIE:
				// Play any movie clips...
				break;
				
			default:
				break;	
		}
		
	}
	
	public void render() {
		
		switch(gameState){
			case MENU:
				// Just show our background, we can add some cool menus and stuff
				// here but for now I'm keeping it simple.
				bg.render();
				break;
			case PLAY:
				// Render both our player and background and in update switch
				// we enable player1.update()
				bg.render();
				player1.render();
				break;
			case PAUSE:
				// Render our player and background but don't allow them to
				// update
				bg.render();
				player1.render();
				break;
			case MOVIE:
				// Play any movie clips...
				break;
			default:
				// Switch cases should almost always have a default case
				// this is so that it catches any unexpected values although.
				break;
		}
		
	}
	
}
