package com.rita.service;

import java.util.List;

import com.rita.bean.TbItem;
import com.rita.result.TaotaoResult;

public interface TbItemService {
	/**
	 * 根据商品id查询商品指定信息
	 * @param tbItemId 商品id
	 * @return 指定商品id的商品信息
	 */
	TbItem findTbItemById(long tbItemId);
	List<TbItem> findTbItemAll(Integer page,Integer limit);
	int findTbItemCount();
	//TaotaoResult deleteItemById(List<TbItem> items);
	/**
	 * 修改商品的状态
	 * @param items
	 * @param type
	 * @return
	 */
	TaotaoResult updateItems(List<TbItem> items, Integer type);
	List<TbItem> searchItem(Integer page,Integer limit,String sellPoint,String title,Long price);
	int searchItemCount(String sellPoint, String title, Long price);
	
}
