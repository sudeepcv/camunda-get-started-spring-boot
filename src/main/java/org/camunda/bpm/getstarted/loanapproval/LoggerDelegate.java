package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class LoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("LoggerDelegate started");

        LOGGER.info("Process is invoked by: ProcessDefinitionId:" + execution.getProcessDefinitionId()
                + "CurrentActivityId:" + execution.getCurrentActivityId() + "CurrentActivityName:"
                + execution.getCurrentActivityName() + "ProcessInstanceId:" + execution.getProcessInstanceId()
                + "ProcessBusinessKey:" + execution.getProcessBusinessKey() + "id:" + execution.getId());

    }

}