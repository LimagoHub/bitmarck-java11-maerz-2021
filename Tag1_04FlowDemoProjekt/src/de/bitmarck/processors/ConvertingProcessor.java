package de.bitmarck.processors;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class ConvertingProcessor extends SubmissionPublisher<Integer> implements Processor <String, Integer>{

	private  Subscription subscription;
	private final Function<String, Integer> function;
	
	
	public ConvertingProcessor(final Function<String, Integer> function) {
		this.function = function;
	}

	@Override
	public void onSubscribe(final Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(String item) {
		try {
			Integer retval = function.apply(item);
			submit(retval);
			
		} catch (Exception e) {
			System.out.println("Problem");
		}
		subscription.request(1);
		
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println(throwable.getMessage());
		
	}

	@Override
	public void onComplete() {
		this.close();
		
	}

}
