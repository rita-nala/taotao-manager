package com.rita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rita.result.EchartsResult;
import com.rita.service.TbItemCatService;

@Controller
@RequestMapping("/itemCat")
public class TbItemCatController {
	@Autowired
	private TbItemCatService tbItemCatService;
	
	@RequestMapping("/statisticsItem")
	@ResponseBody
	public List<EchartsResult> showEcharts(){
		List<EchartsResult> results = tbItemCatService.statisticsItem();
		return results;
	}
}
