package com.rita.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rita.bean.TbItem;
import com.rita.result.TaotaoResult;
import com.rita.result.TbItemResult;
import com.rita.service.TbItemService;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	private TbItemService tbItemService;
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem findTbItemById(@PathVariable long itemId){
		TbItem tbItem = tbItemService.findTbItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/showItem")
	@ResponseBody
	public TbItemResult findTbItemAll(Integer page,Integer limit){
		List<TbItem> tbItems= tbItemService.findTbItemAll(page,limit);
		int count = tbItemService.findTbItemCount();
		TbItemResult tbItemResult = new TbItemResult();
		tbItemResult.setCode(0);
		tbItemResult.setMsg("");
		tbItemResult.setCount(count);
		tbItemResult.setData(tbItems);
		return tbItemResult;
	}
	@RequestMapping("/itemDel")
	@ResponseBody
	public TaotaoResult deleteItemById(@RequestBody List<TbItem> items){
		TaotaoResult result = tbItemService.updateItems(items,0);
		return result;
	}
	@RequestMapping("/itemUp")
	@ResponseBody
	public TaotaoResult itemUp(@RequestBody List<TbItem> items){
		TaotaoResult result = tbItemService.updateItems(items,1);
		return result;
	}
	@RequestMapping("/itemlow")
	@ResponseBody
	public TaotaoResult itemlow(@RequestBody List<TbItem> items){
		TaotaoResult result = tbItemService.updateItems(items,2);
		return result;
	}
	@RequestMapping("/searchItem")
	@ResponseBody
	public TbItemResult TbItemResult(Integer page,Integer limit,String sellPoint,String title,Long price) throws UnsupportedEncodingException{
		byte[] b = title.getBytes("ISO-8859-1");
		title = new String(b,"utf-8");
		byte[] c = sellPoint.getBytes("ISO-8859-1");
		sellPoint = new String(c,"utf-8");
		List<TbItem> item = tbItemService.searchItem(page,limit,sellPoint,title,price);
		int count = tbItemService.searchItemCount(sellPoint,title,price);
		TbItemResult tbItemResult = new TbItemResult();
		tbItemResult.setCode(0);
		tbItemResult.setMsg("");
		tbItemResult.setCount(count);
		tbItemResult.setData(item);
		return tbItemResult;
	}
	
}
