package com.rita.mapper;

import com.rita.bean.TbItem;

public interface TbItemMapper {
	/**
	 * 查询数据库中tbitem表，根据商品id查询商品信息
	 * @param tbItemId
	 * @return
	 */
	TbItem findTbItemById(long tbItemId);

}
