package game;

import java.util.ArrayList;

public abstract class Block {
	private int x, y, z;
	private BlockType type;
	public static float BlockSize = 1;

	public static ArrayList<Block> blocks = new ArrayList<Block>();

	public Block() {
		this(0, 0, 0);
	}

	public Block(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public abstract void draw();

	public void collision() {

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
