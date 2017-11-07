package com.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	static int i=0;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		i=i+1;
		System.out.println("job..."+i);
	}

}
