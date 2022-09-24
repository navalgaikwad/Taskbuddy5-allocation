package com.taskbuddy.clts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Userinfo;
import com.taskbuddy.services.LoginService;
import com.taskbuddy.services.OperationService;
import com.taskbuddy.services.TaskerService;

@Controller
public class LoginController 
{
	@Autowired
	LoginService loginService;
	
	@Autowired
	OperationService operationService;
	
	@Autowired
	TaskerService taskerService;
	
	@RequestMapping("/index")
	public String homePage(HttpSession session)
	{
		return "index";
	}
	
	@RequestMapping("/auth")
	public String pageLogin(Model model)
	{
		Logininfo logininfo=new Logininfo();
		model.addAttribute("logininfo", logininfo);
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginvalid(@Valid @ModelAttribute Logininfo logininfo,BindingResult rs,HttpSession session,Model model)
	{
		
		System.out.println(logininfo);
		System.out.println(rs.toString());
		
		if(session.getAttribute("username")==null) //otherwise username is comming from registration page
		{
			int pendingCount=0;
			if(rs.hasErrors())
				return "login";
			boolean successTasker=loginService.validate(logininfo)&&(loginService.getUser(logininfo.getUsername()).getRole().equals("1"));
			boolean successUser=loginService.validate(logininfo)&&(loginService.getUser(logininfo.getUsername()).getRole().equals("2"));
			boolean isAdmin=loginService.validate(logininfo)&&(loginService.getUser(logininfo.getUsername()).getRole().equals("3"));
			if(successUser||isAdmin||successTasker)
			{
				session.setAttribute("user", loginService.getUser(logininfo.getUsername()));
				session.setAttribute("username", logininfo.getUsername());
				List<Operation> pendingTasks=new ArrayList<>();
				Set<Operation> operations = (loginService.getUser(logininfo.getUsername())).getOperations();
				for(Operation op:operations)
				{
					if(op.getReveiw().equals("incomplete")||op.getReveiw().equals("taskercomplete"))
						{
							pendingTasks.add(op);
							pendingCount++;
						}
				}
				System.out.println("pending count on controller is:"+pendingCount);
				session.setAttribute("pendingTasks",pendingTasks);
				session.setAttribute("pendingCount", pendingCount);
			}
			if(isAdmin)
			{
				return "redirect:adminlistCtrl";
			}
			if(successTasker)
			{
				return "redirect:taskerPageCtrl";
			}
			return successUser?"redirect:test1":"failed";
		}
		return "redirect:test1";
	}
	
	@RequestMapping("/logout")
	public String logoutPage(HttpSession session)
	{
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping("/viewProfile")
	public String showProfile(HttpSession session,Model model)
	{
		System.out.println("inside controller");
		Logininfo logininfo=(Logininfo)session.getAttribute("user");
		Userinfo person=loginService.getUserinfoFromLoginid(logininfo);
		model.addAttribute("person",person);
		String fullname=person.getUserfirstname()+" "+person.getUserlastname();
		model.addAttribute("fullname", fullname);
		return "userProfile";
	}
	
	@RequestMapping("/pendingTasks")
	public String pendingTaskList(HttpSession session,Model model)
	{
		List<Operation> pendingTasks = (List<Operation>) session.getAttribute("pendingTasks");
		//System.out.println(pendingTasks);
		List<Operation> yetToVisit=new ArrayList<>();
		List<Operation> yetToRate=new ArrayList<>();
		for(Operation op:pendingTasks)
		{
			if(op.getReveiw().equals("incomplete"))
			{
				yetToVisit.add(op);
			}
			else if(op.getReveiw().equals("taskercomplete"))
			{
				yetToRate.add(op);
			}
		}
		model.addAttribute("yetToVisit",yetToVisit);
		model.addAttribute("yetToRate",yetToRate);
		return "pendingTasks";
	}
	
	@RequestMapping(value="/writeReview")
	public String writeReview(@RequestParam("opid")int opid,HttpSession session,Model model)
	{
		Operation operation = operationService.fetchOperation(opid);
		model.addAttribute("op",operation);
		return "writeReview";
	}
	
	@RequestMapping("/afterReview")
	public String afterReview(HttpSession session,@ModelAttribute Operation operation)
	{
		//System.out.println(operation);
		operation.setLogininfo(loginService.getLogininfoById(operation.getLogininfo().getLoginid()));
		operation.setTaskerinfo(taskerService.findTasker(operation.getTaskerinfo().getTaskerid()));
		//System.out.println(operation);
		operationService.updateOperation(operation);
		
		
		/*int pendingCount=0;
		List<Operation> pendingTasks=new ArrayList<>();
		Set<Operation> operations = ((Logininfo)session.getAttribute("user")).getOperations();
		for(Operation op:operations)
		{
			if(op.getReveiw().equals("incomplete")||op.getReveiw().equals("taskercomplete"))
				{
					pendingTasks.add(op);
					pendingCount++;
				}
		}
		System.out.println("pending count on controller is:"+pendingCount);
		session.setAttribute("pendingTasks",pendingTasks);
		session.setAttribute("pendingCount", pendingCount);*/
		return "redirect:logout";
		
	}
}
