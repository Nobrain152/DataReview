package main;
import java.awt.EventQueue;

import data.RMIServer;

public class Server {
	private static RMIServer server;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server = new RMIServer(null, "6600");
					server.startRMI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
	