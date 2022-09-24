package com.taskbuddy.clts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Userinfo;
import com.taskbuddy.services.AdminService;

@Controller
/*@RequestMapping("/admin")*/
public class AdminController 
{
@Autowired
AdminService adminservice;
@RequestMapping(value="/adminlistCtrl", method=RequestMethod.GET)
public String index(ModelMap mm,HttpSession session,HttpServletRequest req)
{
	System.out.println("Inside Admin Dao");
	List<Logininfo> logininfo = adminservice.getList();
	mm.put("listTasker", logininfo);
	
	List<Userinfo>userinfo=adminservice.getUserList();
	mm.put("userinfo", userinfo);
	
	List<Operation>operation=adminservice.getOperationList();
	mm.put("operation", operation);
	
	System.out.println(adminservice.getList().toString());
	System.out.println(adminservice.getList().toString());
	return "adminPage";
}

@RequestMapping(value="/add", method=RequestMethod.GET)
public String add(Model mm)
{
	System.out.println("Inside Admin Add");
	mm.addAttribute("listTasker", new Logininfo() );
	
	return "add";
}

@RequestMapping(value="/addTasker", method=RequestMethod.GET)
public String add(@ModelAttribute(value="listTasker")Logininfo listTasker,Model mm)
{
	System.out.println("hi steve ");
	adminservice.addUser(listTasker);
	/*mm.addAttribute("lt", loginService.getList());*/
	return "Admin";
}

@RequestMapping(value="/delete/{loginid}", method=RequestMethod.GET)
public String delete(@PathVariable(value="loginid")int loginid, ModelMap mm)
{
	System.out.println("hi steve ");
	adminservice.deleteTasker(loginid);
List<Logininfo> li = adminservice.getList();
mm.put("listTasker", li);
	return "Admin";
}

@RequestMapping(value="/update/{loginid}", method=RequestMethod.GET)
public String update(@PathVariable(value="loginid")int loginid, ModelMap mm)
{
	System.out.println("hi steve ");

mm.put("listTasker", adminservice.findTasker(loginid));
	return "update";
}

@RequestMapping(value="/update", method=RequestMethod.GET)
public String updateTasker(@PathVariable(value="listTasker")Logininfo listTasker,Model mm)
{
	System.out.println("hi steve ");
/*loginService.update(listTasker);*/
/*mm.put("listTasker", loginService.findAll());*/
	return "adminPage";
}

}
