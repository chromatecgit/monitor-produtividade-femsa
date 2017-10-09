package br.com.shelfpix.util;


public class Chronometer {
	private static long startTime;
	private static long stopTime;
	
	public static void start() {
		startTime = System.currentTimeMillis();
	}
	
	public static void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public static void getTime(final String title) {
		System.out.println(title);
		long seconds = (stopTime - startTime) / 1000;
		if (seconds >= 60) {
			System.out.println("Tempo: " + seconds / 60 + " minutos e " + seconds % 60 + " segundos");
		} else {
			System.out.println("Tempo: " + seconds);
		}
		startTime = 0L;
		stopTime = 0L;
	}
	
}
