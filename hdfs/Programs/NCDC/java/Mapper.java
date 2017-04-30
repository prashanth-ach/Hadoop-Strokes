package Scrape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapper {
	private static final int MISSING = 9999;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("/home/magnetto/workspace/Java-Pixels/txtdata/1901"));

		String line = null;
		int max = 0;

		while ((line = bufferedReader.readLine()) != null) {

			// String year =line.substring(15,19);

			int temperature;

			if (line.charAt(87) == '+') {
				temperature = Integer.parseInt(line.substring(88, 92));
			} else {
				temperature = Integer.parseInt(line.substring(87, 92));
			}
			String quality = line.substring(92, 93);

			if (temperature != MISSING && quality.matches("[01459]"))

			{
				int n = temperature;

				if (n > max) {
					max = n;
				}
			}
		}
		System.out.println(max);
		bufferedReader.close();
	}
}
