package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Launcher implements Runnable {
	private JFrame launcher;
	private JPanel panel;
	private JButton play;
	private JEditorPane changelog;
	private JComboBox version;
	public static String[] versions = { "0.0.1", "0.0.2" };
	private Thread thread;
	private boolean running = false;
	private String url = "http://localhost/changelog.html";
	private JScrollPane scroll;

	public Launcher() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		}
		launcher = new JFrame("Launcher");
		panel = new JPanel();
		panel.setLayout(null);
		play = new JButton("Play");
		launcher.setSize(800, 600);
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		version = new JComboBox(versions);
		version.setSelectedIndex(versions.length - 1);
		version.setBounds(launcher.getWidth() / 2 + 100, 500, 100, 50);
		version.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Item Selected!");
				}
			}

		});
		version.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

			}

			public void focusLost(FocusEvent e) {

			}

		});
		play.setBounds(launcher.getWidth() / 2 - 50, 500, 100, 50);

		changelog = new JEditorPane();
		changelog.setEditable(false);
		changelog.setBounds(25, 25, 750, 425);
		changelog.setContentType("text/html");
		scroll = new JScrollPane(changelog);
		scroll.setBounds(25, 25, 750, 425);
		panel.validate();
		panel.repaint();
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {

		launcher.setLocationRelativeTo(null);

		while (running) {
			launcher.setVisible(true);
			launcher.add(panel);
			panel.add(play);
			panel.add(version);

			panel.add(scroll);
			play.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					launcher.dispose();
					running = false;
					new Game(version.getSelectedIndex());

				}

			});
			try {
				changelog.setPage(url);
			} catch (IOException ex) {
				Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		try {
			thread.join();
		} catch (InterruptedException ex) {
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
