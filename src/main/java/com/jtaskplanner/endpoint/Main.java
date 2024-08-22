package com.jtaskplanner.endpoint;


import com.jtaskplanner.planner.PlanBuilder;
import com.jtaskplanner.trigger.Trigger;
import com.jtaskplanner.trigger.TriggerBuilder;
import com.jtaskplanner.task.Task;
import com.jtaskplanner.task.TaskBuilder;
import com.jtaskplanner.timer.TimerBuilder;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		Trigger trigger = TriggerBuilder.newTrigger()
				.rename("Nova tarefa")
				.when(
					TimerBuilder.newTimer()
					.interval(1000)
					.repeat(10)
				);
		
		Task task = TaskBuilder.newTask()
			.rename("Tarefa de teste 18h mes 8")
			.setTask(new TarefaTeste());

		PlanBuilder.newPlanner()
		.setOutput("./")
		.planTask(trigger, task)
		.start();
		
		PlanBuilder.newPlanner()
			.setOutput("./")
			.cron("* 10 * * *", task)
			.start();
		
		
		PlanBuilder.keepRunning();
	}

}
