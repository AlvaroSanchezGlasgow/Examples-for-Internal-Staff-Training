package com.course.batch.tasklet;


import org.springframework.batch.core.StepContribution;

import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.course.batch.service.EmailService;



public class ProcessTasklet implements Tasklet, InitializingBean {

	@Autowired
	EmailService emailService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		System.out.println("=============== BEFORE SEND EMAIL ===================");
		emailService.sendEmail();
		System.out.println("=============== AFTER SEND EMAIL ===================");
		return RepeatStatus.FINISHED;
	}

	
}
