package ru.studen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.studen.impl.RoleServiceClient;
import ru.studen.pojo.RolePojo;
import ru.studen.services.IRoleService;
import ru.studen.services.RoleService;

import java.util.List;

/**
 * Created in project RiddlesAndPuzzles in 12.01.17
 */
@Controller
public class IndexController extends BaseController
{
	@Autowired
	private RoleServiceClient roleServiceClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model)
	{
		IRoleService roleService = roleServiceClient.getRoleService();
		List<RolePojo> roles = roleService.getAll();

		return "index";
	}
}
