package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 * The main interface of the application
 * 
 * @author GOXR3PLUS
 *
 */
public class MainInterfaceController extends BorderPane {

	// Thread used to communicate between logic and GUI
	Thread commThread;

	String Ace;
	String You;


	@FXML
	public TextArea infoArea;

	// -----------------------------------------

	private General gen = new General();

	/**
	 * Constructor
	 */
	public MainInterfaceController() {

		// FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainInterfaceController.fxml"));
		loader.setController(this);
		loader.setRoot(this);

		try {
			loader.load();
		} catch (IOException ex) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, " FXML can't be loaded!", ex);
		}

	}

	protected void startCommThread() {

		// alive?
		if (commThread != null && commThread.isAlive())
			return;

		commThread = new Thread(() -> {
			try {

				// Detect if the microphone is available
				while (true) {

					Communication comm = Communication.getInstance();

					Ace = comm.getAce();
					You = comm.getYou();

					if (comm.getYappear()) {
						infoArea.appendText("You: " + comm.getYou() + "\n");
						comm.setYappear(false);
					}

					if (comm.getAppear()) {
						infoArea.appendText("Ace: " + Ace + "\n");
						comm.setAppear(false);
					}

					Thread.sleep(10);
				}

			} catch (InterruptedException ex) {

				commThread.interrupt();
			}
		});

		// Start
		commThread.start();
	}

	/**
	 * As soon as fxml has been loaded then this method will be called
	 * 1)-constructor,2)-FXMLLOADER,3)-initialize();
	 */
	@FXML
	private void initialize() {

		//PLACE FOR ACTION EVENTS
		
		
		startCommThread();

	}
}
