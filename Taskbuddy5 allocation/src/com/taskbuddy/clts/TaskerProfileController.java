package com.taskbuddy.clts;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorPower;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;
import com.taskbuddy.services.OperationService;
import com.taskbuddy.services.TaskerService;

@Controller
public class TaskerProfileController 
{
	@Autowired
	TaskerService taskerService;
	
	@Autowired
	OperationService operationService;
	
	@RequestMapping("/taskerPageCtrl")
	public String taskerPage(Model model,HttpSession session)
	{
		boolean isPending=false;
		Logininfo userTasker=(Logininfo)session.getAttribute("user");
		Taskerinfo taskerinfo =(Taskerinfo)userTasker.getTaskerinfos().toArray()[0];
		session.setAttribute("tasker",taskerinfo);
		System.out.println(taskerinfo);
		isPending= (!taskerinfo.isStatus());
		session.setAttribute("isPending", isPending);
		System.out.println("isPending in controller is:"+isPending);
		return "taskerPage";
	}
	
	@RequestMapping("/jobDetail")
	public String viewTaskDetails(HttpSession session,Model model)
	{
		Taskerinfo tasker = (Taskerinfo)session.getAttribute("tasker");
		Set<Operation> operations = tasker.getOperations();
		for(Operation op:operations)
		{
			if(op.getReveiw().equals("incomplete"))
			{
				model.addAttribute("operation", op);
				Userinfo appointer = (Userinfo)op.getLogininfo().getUserinfos().toArray()[0];
				model.addAttribute("appointer", appointer);
				//System.out.println(op);
			}
				
		}
		return "taskDetails";
	}
	
	@RequestMapping(value="/accomplishment")
	public String accomFromTasker(@RequestParam("opid")int opid,HttpSession session)
	{
		//System.out.println(opid);
		Operation operation = operationService.fetchOperation(opid);
		operation.setReveiw("taskercomplete");
		operationService.updateOperation(operation);
		Taskerinfo taskerinfo =(Taskerinfo) session.getAttribute("tasker");
		taskerinfo.setStatus(true);
		taskerService.updateTasker(taskerinfo);
		return "redirect:taskerPageCtrl";
	}
}
