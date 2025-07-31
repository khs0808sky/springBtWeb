package app.labs.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.labs.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("dept")
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@GetMapping(value= {"", "/", "main"})
	public String main(Model model) {
		model.addAttribute("serverTime", "서버시간");
		return "dept/main";
	}
	
	@GetMapping(value= {"count"})
	public String getDeptCount(@RequestParam(value="deptid", required=false, defaultValue="0") int deptno, Model model) {

		if (deptno == 0) {
			model.addAttribute("count", deptService.getDeptCount());
		} else {
			model.addAttribute("count", deptService.getDeptCount(deptno));
		}
		
        return "dept/main";
    }
}
