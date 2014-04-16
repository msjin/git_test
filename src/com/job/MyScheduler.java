package com.job;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {

	public static void main(String[] args) {
		MyScheduler t = new MyScheduler();
		try {
			t.scheduleJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void scheduleJob() throws SchedulerException{
//		SchedulerFactory sf = new StdSchedulerFactory();
//		Scheduler scheduler = StdSchedulerFactory.getScheduler();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
//		JobDetail job = new JobDetailImpl(); 
		JobDetail job = new JobDetail();
		job.setName("test");
		job.setGroup(Scheduler.DEFAULT_GROUP);
		job.setJobClass(MyJob.class); //注意这里
		job.getJobDataMap().put("a", "a");
		
		SimpleTrigger st = new SimpleTrigger("simpleTrigger","s1");
		st.setStartTime(new Date());
		st.setRepeatInterval(10000);
		st.setRepeatCount(10);
		
		scheduler.scheduleJob(job, st);
		scheduler.start();
	}
}
