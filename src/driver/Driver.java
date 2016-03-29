package driver;

import static org.lwjgl.glfw.GLFW.*; // allows us to create windows
import static org.lwjgl.opengl.GL11.*; // gives us access to things like "GL_TRUE" which we'll need 
import static org.lwjgl.system.MemoryUtil.*; // allows us to use 'NULL' in our code, note this is slightly different from java's 'null'
import java.nio.ByteBuffer; // Used for getting the primary monitor later on.

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import game.Game;
import input.KeyboardHandler;
import network.NetworkClient;

public class Driver implements Runnable{

	public Thread thread;
	public boolean running;
	public long window;
	
	private Game game;
	
	private static NetworkClient client;
	
	// This prevents our window from crashing later on.
	private GLFWKeyCallback keyCallback;
	
	public void start(){
		this.running = true;
		thread = new Thread(this,"Pong");
		thread.start();
	}
	
	public void init(){
		if(glfwInit() != GL_TRUE){
			System.err.println("Failed to initialize GLFW");
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(800, 600, "Pong", NULL, NULL);
		if(window == NULL){
			System.err.println("Failed to create window");
		}
		glfwSetWindowPos(window, 199, 100);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		// Initialise OpenGL and set the context
		GL.createCapabilities();
		glViewport(0, 0, Game.WIDTH, Game.HEIGHT);
		glClearColor(0.3f,0.7f,0.92f,1.0f);		
		
		// Enables depth testing which will be important to make sure
		// triangles are not rendering in front of each other when they
		// shouldn't be.
		glEnable(GL_DEPTH_TEST);
		// Sets our keycallback to equal our newly created Input class()
		glfwSetKeyCallback(window, keyCallback = new KeyboardHandler());		
		
		client = new NetworkClient();

		game = new Game();
	}
	
	public void update(){
		
		game.update();
		// Polls for any window events such as the window closing etc.
		glfwPollEvents();
		
	}
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		game.render();
		glfwSwapBuffers(window);
	}
	
	@Override
	public void run(){
		init();
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}
			render();		
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
			if(glfwWindowShouldClose(window) == GL_TRUE){
				running = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		driver.start();
	}

}
