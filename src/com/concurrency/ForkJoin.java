package com.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	
	private static final int DIRECT_TASK_THRESHOLD = 2;
	private static final int NUMBER_THREADS = 5;

	private final int[] data;
	private final int start;
	private final int end;

	public ForkJoin(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	public ForkJoin(int[] data) {
		this(data, 0, data.length);
	}

	@Override
	protected Integer compute() {
		final int length = end - start;
		if (length <= DIRECT_TASK_THRESHOLD) {
			return computeDirectly();
		}
		
		final int split = length / 2;
		
		System.out.println("Thread '" + Thread.currentThread().getName() + "' spawning new thread to work between " + start + " and " + (start + split - 1));
		final ForkJoin left = new ForkJoin(data, start, start + split);
		left.fork(); //FORK
		
		System.out.println("Thread '" + Thread.currentThread().getName() + "' working between " + (start + split ) + " and " + ( end - 1) );
		final ForkJoin right = new ForkJoin(data, start + split, end);
		return Math.max(right.compute(), left.join()); //JOIN
	}

	private Integer computeDirectly() {
		System.out.println("Thread '" +  Thread.currentThread().getName() + "' computing: " + start + " to " + ( end - 1) );
		int max = Integer.MIN_VALUE;
		for (int i = start; i < end; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// create data
		final int[] data = new int[10];
		for (int i = 0; i < data.length; i++) {
			data[i] = i;
		}

		// submit the task to the pool
		final ForkJoinPool pool = new ForkJoinPool(NUMBER_THREADS);
		final ForkJoin finder = new ForkJoin(data);

		// invoke recursive task 
		Integer max = pool.invoke(finder);
		System.out.println("The maximum number is: " + max);
	}
}