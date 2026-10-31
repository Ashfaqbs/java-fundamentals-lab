package ChatGpt;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class YouTubeDataRetriever {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the YouTube video URL: ");
		String videoUrl = scanner.nextLine();
		scanner.close();

		String videoId = extractVideoId(videoUrl);
		// String downloadUrl = "https://www.youtube.com/get_video_info?video_id=" +
		// videoId;

		URL url = new URL(videoUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		// con.setRequestProperty("User-Agent", "Mozilla/5.0");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		FileOutputStream outputStream = new FileOutputStream("video1.mp4");
		String response = reader.readLine();
		while (response != null) {
			System.out.println(response);

			response = reader.readLine();
			outputStream.write(response.getBytes());
		}
		reader.close();
	}

	private static String extractVideoId(String videoUrl) {
		// extract the video id from the video URL
		String[] urlParts = videoUrl.split("v=");
		return urlParts[1];
	}
}
