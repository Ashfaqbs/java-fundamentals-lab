package Java_NET;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubProfileCaller {

	public static void main(String[] args) {
		String urlString = "https://api.github.com/users/Ashfaqbs"; // Replace 'username' with the actual GitHub
																	// username
		HttpClient client = HttpClient.newHttpClient();

		for (int i = 0; i < 10; i++) {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString))
					.header("Accept", "application/vnd.github+json").header("User-Agent", "Mozilla/5.0").build();

			try {
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				System.out.println("Response: " + response.body());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
