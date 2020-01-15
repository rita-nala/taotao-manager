package com.rita.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rita.bean.TbItem;
import com.rita.mapper.TbItemMapper;
import com.rita.result.TaotaoResult;
import com.rita.service.TbItemService;
@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem findTbItemById(long tbItemId) {
		TbItem tbItem = tbItemMapper.findTbItemById(tbItemId);
		return tbItem;
	}
	@Override
	public List<TbItem> findTbItemAll(Integer page,Integer limit) {
		List<TbItem> tbItems = tbItemMapper.findTbItemAll((page-1)*limit,limit);
		return tbItems;
	}
	@Override
	public int findTbItemCount() {
		int count = tbItemMapper.findTbItemCount();
		return count;
	}
//	@Override
//	public TaotaoResult deleteItemById(List<TbItem> items) {
//		List<Long> ids = new ArrayList<Long>();
//		for (TbItem item : items) {
//			ids.add(item.getId());
//		}
//		int count = tbItemMapper.deleteItemById(ids);
//		if (count>0) {
//			return TaotaoResult.ok();
//		}
//		return TaotaoResult.build(500, "删除有误");
//	}
	@Override
	public TaotaoResult updateItems(List<TbItem> items, Integer type) {
		List<Long> ids = new ArrayList<Long>();
		for (TbItem tbItem : items) {
			ids.add(tbItem.getId());
		}
		int count = tbItemMapper.updateItemByIds(ids, type);
		if (count>0&&type==0) {
			return TaotaoResult.build(200, "商品删除成功");
		}else if (count>0&&type==1){
			return TaotaoResult.build(200, "商品上架成功");
		}else if (count>0&&type==2) {
			return TaotaoResult.build(200, "商品下架成功");
		}
		return TaotaoResult.build(500, "操作有误");
	}
	@Override
	public List<TbItem> searchItem(Integer page, Integer limit, String sellPoint, String title, Long price) {
		List<TbItem> items = tbItemMapper.searchItem((page-1)*limit,limit,sellPoint,title,price);
		
		return items;
	}
	@Override
	public int searchItemCount(String sellPoint, String title, Long price) {
		int count = tbItemMapper.searchItemCount(sellPoint,title,price);
		return count;
	}
	
}
