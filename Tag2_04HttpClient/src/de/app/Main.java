package de.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

	private static final String PATH_TO_SERVICE = "http://localhost:8080/math/add";

	public static void main(String[] args) throws IOException, InterruptedException {
		final var publisher = BodyPublishers.ofString("{\"a\":1,\"b\":10}");
		final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(PATH_TO_SERVICE)).setHeader("Content-Type", "application/json").POST(publisher).build();
		final HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).build();
		
		
		
		
		final var future = client.sendAsync(request, BodyHandlers.ofString());
		
		
		future.thenAccept(response-> {
			System.out.println(response.statusCode());
			System.out.println(response.body());
		});
	
		
		
		
		
		
		Thread.sleep(1000);
		
	}

}
