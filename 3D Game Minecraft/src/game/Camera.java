package game;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {
	private float x;
	private float y;
	private float z;
	private float rx;
	private float ry;
	private float rz;

	private float fov;
	private float aspect;
	private float near;
	private float far;

	public Camera(float fov, float aspect, float near, float far) {
		x = 0;
		y = 0;
		z = 0;
		rx = 0;
		ry = 0;
		rz = 0;
		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		initProjection();
	}

	private void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspect, near, far);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
	}

	public void useView() {
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);
		glTranslatef(x, y, z);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getRX() {
		return rx;
	}

	public float getRY() {
		return ry;
	}

	public float getRZ() {
		return rz;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setRX(float rx) {
		this.rx = rx;
	}

	public void setRY(float ry) {
		this.ry = ry;
	}

	public void setRZ(float rz) {
		this.rz = rz;
	}

	public void move(float dir, float amt) {
		z += amt * Math.sin(Math.toRadians(ry + 90 * dir));
		x += amt * Math.cos(Math.toRadians(ry + 90 * dir));
	}

	public void rotateY(float amt) {
		ry += amt;
	}

	public void rotateX(float amt) {
		// System.out.println("Old rx: " + rx);
		if (rx + amt > 90) {
			rx = 90;
			return;
		}
		if (rx + amt < -90) {
			rx = -90;
			return;
		}
		rx += amt;
		// System.out.println("New rx:" + rx);
	}

	public void jump(float amt) {
		y += amt;
	}
}
