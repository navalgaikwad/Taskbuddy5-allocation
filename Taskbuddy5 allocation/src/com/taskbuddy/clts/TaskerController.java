package com.taskbuddy.clts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;
import com.taskbuddy.models.LocationModel;
import com.taskbuddy.models.Review;
import com.taskbuddy.models.TaskerUserModel;
import com.taskbuddy.services.LoginService;
import com.taskbuddy.services.OperationService;
import com.taskbuddy.services.TaskerService;

@Controller
public class TaskerController 
{
	@Autowired
	TaskerService taskerService;
	@Autowired
	LoginService loginService;
	@Autowired
	OperationService operationService;
	
	@RequestMapping("/quickBook")
	public String bookQuickly(HttpSession session)
	{
		Logininfo user=(Logininfo) session.getAttribute("user");
		Object[] objs=user.getUserinfos().toArray();
		Userinfo userinfo=(Userinfo)objs[0];
		String str="redirect:categorySelection?location="+userinfo.getLocation();
		return str;
	}
	
	@RequestMapping("/test1")
	public String TestForLocation(HttpSession session,Model model)
	{
		List<String> cityList=taskerService.fetchCities();
		//System.out.println(cityList);
		model.addAttribute("cityList", cityList);
		return "cities";
	}
	
	@RequestMapping(value="/locationSelection",method=RequestMethod.GET)
	public String locationsFromCity(@RequestParam("city") String city,Model model,HttpSession session)
	{
		//System.out.println(city);
		List<String> locationList=taskerService.fetchLocationsInCity(city);
		System.out.println(locationList);
		model.addAttribute("locationList", locationList);
		return "locations";
	}
	
	@RequestMapping(value="/categorySelection",method=RequestMethod.GET)
	public String categoriesInLocation(@RequestParam("location") String location,Model model,HttpSession session)
	{
		//System.out.println(location);
		List<String> categoryList=taskerService.fetchCategoriesInLocation(location);
		//System.out.println(categoryList);
		session.setAttribute("location", location);
		model.addAttribute("categoryList", categoryList);
		LocationModel lm=new LocationModel();
		model.addAttribute("command", lm);
		return "categories";
	}
	
	@RequestMapping(value="/taskerSelection",method=RequestMethod.GET)
	public String taskersFromCategory(@RequestParam("category")String category,HttpSession session,Model model)
	{
		String location=(String) session.getAttribute("location");
		List<Taskerinfo> taskerList=taskerService.fetchTaskerByCategory(location,category);
		session.setAttribute("taskerList", taskerList);
		return "redirect:taskersSel";
	}
	
	@RequestMapping(value="/taskersSel")
	public String getTaskers(HttpSession session,Model model)
	{
		int rating=0,totalRating=0,count=0;
		List<Taskerinfo> taskerList=(List<Taskerinfo>)session.getAttribute("taskerList");
		System.out.println(taskerList);
		List<TaskerUserModel> tlist=new ArrayList<>();
		for(Taskerinfo t1:taskerList)
		{
			Logininfo logininfo=t1.getLogininfo();
			Object[] objs=logininfo.getUserinfos().toArray();
			Set<Operation> operationsTillNow = t1.getOperations();
			for(Operation op:operationsTillNow)
			{
				if(!op.getReveiw().equals("incomplete"))
				{
					totalRating+=op.getRating();
					count++;
				}
			}
			if(count>0)
			{
				rating=totalRating/count;
			}
			for(Object obj:objs)
			{
				Userinfo taskerUser= (Userinfo)obj;
				TaskerUserModel tum=new TaskerUserModel(logininfo.getLoginid(),t1.getTaskerid(),taskerUser.getUserfirstname(),taskerUser.getUserlastname(),taskerUser.getContactno(),t1.getCharge(),rating);
				tlist.add(tum);
			}	
		}
		model.addAttribute("tlist", tlist);
		return "taskers";
	}
	
	@RequestMapping(value="/displayReviews")
	public String displayReviews(@RequestParam("tasker")int taskerid,Model model)
	{
		//System.out.println(taskerid);
		Taskerinfo tasker = taskerService.findTasker(taskerid);
		Set<Operation> operationsTillNow = tasker.getOperations();
		List<Review> reviews=new ArrayList<>();
		for(Operation op:operationsTillNow)
		{
			if(!op.getReveiw().equals("incomplete"))
			{
				Review review=new Review();
				Userinfo cust = (Userinfo) op.getLogininfo().getUserinfos().toArray()[0];
				review.setCustomer(cust.getUserfirstname()+" "+cust.getUserlastname());
				review.setReview(op.getReveiw());
				review.setRating(op.getRating());
				reviews.add(review);
			}
		}
		model.addAttribute("reviews",reviews);
		return "reviewPage";
	}
	
	@RequestMapping(value="/bookTasker")
	public String ConfirmBooking(HttpSession session,Model model,@RequestParam("tasker")int taskerid)
	{
		Operation op=new Operation();
		op.setTaskerinfo(taskerService.findTasker(taskerid));
		model.addAttribute("op", op);
		return "confirmBooking";
	}
	
	@RequestMapping(value="booking")
	public String bookTasker(@ModelAttribute Operation operation)
	{
		//System.out.println(operation);
		Logininfo logininfo=loginService.getLogininfoById(operation.getLogininfo().getLoginid());
		operation.setLogininfo(logininfo);
		Taskerinfo taskerinfo=taskerService.findTasker(operation.getTaskerinfo().getTaskerid());
		operation.setTaskerinfo(taskerinfo);
		System.out.println(operation);
		operationService.saveOperation(operation);
		return "booked";
	}
}
