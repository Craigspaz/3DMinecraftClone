package game;

import static org.lwjgl.opengl.GL11.*;

public class GrassBlock extends Block {

	public GrassBlock(int x, int y, int z) {
		super(x, y, z);
	}

	public void draw() {
		glPushMatrix();
		// GFX.drawCubeFromCorner(this.getX(), this.getY(), this.getZ(),Textures.grass);
		GFX.drawGrass(this.getX(), this.getY(), this.getZ(), Textures.grass, Textures.grassTop, Textures.dirt);
		glPopMatrix();
	}

}
