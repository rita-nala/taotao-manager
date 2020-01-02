package com.rita.service;

import com.rita.bean.TbItem;

public interface TbItemService {
	/**
	 * 根据商品id查询商品指定信息
	 * @param tbItemId 商品id
	 * @return 指定商品id的商品信息
	 */
	TbItem findTbItemById(long tbItemId);
}
