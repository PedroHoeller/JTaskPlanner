package com.jtaskplanner.endpoint;

import com.jtaskplanner.task.TaskDetail;

public class TarefaTeste implements TaskDetail{
	private int i =0;
	@Override
	public void execute() {
		System.out.println("Teste script - " + i );
		i++;
	}
}
