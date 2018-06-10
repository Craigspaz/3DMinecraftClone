package game;

import static org.lwjgl.opengl.GL11.*;

public class DirtBlock extends Block {

	public DirtBlock(int x, int y, int z) {
		super(x, y, z);
	}

	public void draw() {
		glPushMatrix();
		GFX.drawCubeFromCorner(this.getX(), this.getY(), this.getZ(), Textures.dirt);
		glPopMatrix();
	}

}
