package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.File;
import java.io.FileWriter;


public class ParseTemplate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("Template parsing has started.........       ");


                VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(/* Give the template file location here */"./src/conf.tpl.txt");
        VelocityContext context = new VelocityContext();
        // template output file
        FileWriter writer = new FileWriter(new File("./src/conf.tpl.output.txt"));

        String name= (String) execution.getVariable("NAME");

        System.out.println("Name from process variable is:"+name);


        context.put("NAME", name);
        context.put("CONDITION",true);
        template.merge(context, writer);
        writer.flush();
        writer.close();

         System.out.println("Template parsing successful.........       ");



	}

}