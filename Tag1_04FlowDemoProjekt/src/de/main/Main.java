package de.main;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import de.bitmarck.processors.ConvertingProcessor;
import de.bitmarck.subscribers.EndSubscriber;

public class Main {

	public static void main(String[] args) throws Exception{
	
		System.out.println("Main-Start");
		
		List<String> items = List.of("eins","zwei","1","2","drei","4");
		
		EndSubscriber<Integer> subscriber = new EndSubscriber<>();
		ConvertingProcessor processor = new ConvertingProcessor(s->Integer.valueOf(s));
		
		ExecutorService service = ForkJoinPool.commonPool();
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>(service, 1);
		publisher.subscribe(processor);
		processor.subscribe(subscriber);
		
		items.forEach(publisher::submit);
		
		publisher.close();
		

		service.shutdown();
		
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		System.out.println("Main-Ende");
		
		
		
		
		

	}
	
	static class MyWorker implements Runnable {
		
		private Random random = new Random();

		@Override
		public void run() {
			try {
				long value = random.nextInt(2000);
				Thread.sleep(value);
				System.out.println(Thread.currentThread().getId() +  " fertig nach " + value + "millis");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
