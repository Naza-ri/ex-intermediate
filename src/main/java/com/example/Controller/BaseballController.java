package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Baseballteam;
import com.example.Service.BaseballService;

@Controller
@RequestMapping("/")
public class BaseballController {
	@Autowired
	private BaseballService baseballservice;

	/**
	 * チーム一覧画面の表示.
	 * 
	 * @param model モデル
	 * @return チーム一覧画面表示
	 */
	@RequestMapping("/teamlist")
	public String teamList(Model model) {
		List<Baseballteam> teamList = baseballservice.showList();
		model.addAttribute("teamList", teamList);
		return "teamList";
	}

	/**
	 * 
	 * 球団詳細画面の表示.
	 * 
	 * @param id    ID
	 * @param model モデル
	 * @return 球団詳細画面の表示
	 */
	@RequestMapping("/teamdetail")
	public String teamDetail(Integer id, Model model) {
		Baseballteam baseballteam = baseballservice.showDetail(id);
		model.addAttribute("baseballteam", baseballteam);
		return "teamdetail";
	}
}