package game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game {

	private State state = State.Game;
	public static int version;

	public Game(int version) {
		try {
			Display.setDisplayMode(new DisplayMode(1920, 1080));
			Display.create();
			Display.setTitle("Game");
			Mouse.create();
			Keyboard.create();
			Display.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Game.version = version;
		run();
	}

	public void run() {
		Textures texture = new Textures();
		Block.blocks.add(new GrassBlock(0, 0, 0));
		Block.blocks.add(new GrassBlock(1, 0, 1));
		Block.blocks.add(new GrassBlock(1, 1, 1));
		Block.blocks.add(new GrassBlock(2, 0, 1));
		Block.blocks.add(new GrassBlock(3, 0, 1));
		Block.blocks.add(new GrassBlock(4, 0, 1));
		Block.blocks.add(new GrassBlock(5, 0, 1));
		Block.blocks.add(new GrassBlock(6, 0, 1));
		Block.blocks.add(new GrassBlock(7, 0, 1));
		Block.blocks.add(new GrassBlock(8, 0, 1));
		Block.blocks.add(new GrassBlock(15, 4, 1));
		Camera cam = new Camera(70, Display.getWidth() / Display.getHeight(), 0.03f, 50);
		while (!Display.isCloseRequested()) {
			if (state == State.Intro) {
				System.out.println("Intro...\n");
				System.out.println(Game.version);
				if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
					state = State.Main;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (state == State.Main) {
				System.out.println("Main_Menu...\n");
				if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
					state = State.Game;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (state == State.Game) {
				// System.out.println("Game...\n");

				boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W);
				boolean backward = Keyboard.isKeyDown(Keyboard.KEY_S);
				boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
				boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);

				boolean lookRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
				boolean lookLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
				boolean lookUp = Keyboard.isKeyDown(Keyboard.KEY_UP);
				boolean lookDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN);

				boolean FlyUp = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
				boolean FlyDown = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);

				if (lookRight) {
					cam.rotateY(5f);
				}
				if (lookLeft) {
					cam.rotateY(-5f);
				}
				if (lookUp) {
					cam.rotateX(-5f);
				}
				if (lookDown) {
					cam.rotateX(5f);
				}

				if (forward) {
					cam.move(1, 0.025f);
				}
				if (backward) {
					cam.move(1, -0.025f);
				}
				if (left) {
					cam.move(0, 0.025f);
				}
				if (right) {
					cam.move(0, -0.025f);
				}
				if (FlyUp) {
					cam.jump(-0.025f);
				}
				if (FlyDown) {
					cam.jump(0.025f);
				}
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
				glLoadIdentity();
				cam.useView();

				for (Block e : Block.blocks) {
					e.draw();
				}

				System.out.println("X: " + cam.getX() + " Y: " + cam.getY() + " Z: " + cam.getZ());

				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
					state = State.In_Game;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (state == State.In_Game) {
				System.out.println("In_Game...\n");
			}

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		System.exit(0);
	}

	public static void main(String[] args) {
		// Launcher l = new Launcher();
		// l.start();
		new Game(2);
	}
}
