package Java_NET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

//this class will take the whole html of that url and print
public class WebClient1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://jar-download.com/");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		reader.close();
	}
}
