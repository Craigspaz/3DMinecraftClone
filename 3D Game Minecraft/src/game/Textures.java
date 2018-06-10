package game;

import static game.LoadTexture.loadTexture;

import org.newdawn.slick.opengl.Texture;

public class Textures {
	public static Texture air, dirt, grass, grassTop, stone, Exit_First, Exit_Second, Play_First, Play_Second,
			Resume_First, Resume_Second, Laser, Highlight, Play, Play1, Pause, Pause1;
	public static Texture Enemy1, Enemy2, Enemy3, Enemy4, Enemy5, Enemy6, Enemy7, Enemy8;
	public static Texture Tower1, Tower2, Tower3, Tower4;

	public static Texture Trash;

	public static Texture RangeUpgrade, DamageUpgrade;

	public static Texture logo;

	public Textures() {
		air = loadTexture("air");
		dirt = loadTexture("dirt");
		grass = loadTexture("grass");
		grassTop = loadTexture("grassTop");
		stone = loadTexture("stone");
		Exit_First = loadTexture("Buttons/Exit_First");
		Play_First = loadTexture("Buttons/Play_First");
		Exit_Second = loadTexture("Buttons/Exit_Second");
		Play_Second = loadTexture("Buttons/Play_Second");
		Resume_First = loadTexture("Buttons/Resume_First");
		Resume_Second = loadTexture("Buttons/Resume_Second");
		Laser = loadTexture("Laser");
		Highlight = loadTexture("Highlighted Area");
		Play = loadTexture("Buttons/Play");
		Play1 = loadTexture("Buttons/Play1");
		Pause = loadTexture("Buttons/Pause");
		Pause1 = loadTexture("Buttons/Pause1");

		Enemy1 = loadTexture("Enemy/Enemy1");
		Enemy2 = loadTexture("Enemy/Enemy2");
		Enemy3 = loadTexture("Enemy/Enemy3");
		Enemy4 = loadTexture("Enemy/Enemy4");
		Enemy5 = loadTexture("Enemy/Enemy5");
		Enemy6 = loadTexture("Enemy/Enemy6");
		Enemy7 = loadTexture("Enemy/Enemy7");
		Enemy8 = loadTexture("Enemy/Enemy8");

		Tower1 = loadTexture("Tower/Tower1");
		Tower2 = loadTexture("Tower/Tower2");
		Tower3 = loadTexture("Tower/Tower3");
		Tower4 = loadTexture("Tower/Tower4");

		logo = loadTexture("logo");

		Trash = loadTexture("Trash");

		RangeUpgrade = loadTexture("Upgrades/Range");
		DamageUpgrade = loadTexture("Upgrades/Damage");
	}
}
