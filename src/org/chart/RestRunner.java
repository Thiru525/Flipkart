package org.chart;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({Flipkart.class,Amazon.class})


//Either execute by runWith or JUnitCore.
public class RestRunner {
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(Flipkart.class,Amazon.class);
		List<Failure> faiures = result.getFailures();
		for (Failure failure : faiures) {
			System.out.println(faiures);
			
		}
		System.out.println("Total run count is :"+result.getRunCount());
		System.out.println("Total Ignore count is :"+result.getIgnoreCount());
		System.out.println("Total Failure count is :"+result.getFailureCount());
		System.out.println("Total run Time is :"+result.getRunTime());
	}

}
