package com.rita.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rita.bean.TbItem;

public interface TbItemMapper {
	/**
	 * 查询数据库中tbitem表，根据商品id查询商品信息
	 * @param tbItemId
	 * @return
	 */
	TbItem findTbItemById(long tbItemId);

	List<TbItem> findTbItemAll(Integer page,Integer limit);

	int findTbItemCount();

	//int deleteItemById(@Param("ids") List<Long> ids);

	int updateItemByIds(@Param("ids") List<Long> ids,@Param("type") Integer type);

	List<TbItem> searchItem(@Param("page") Integer page,@Param("limit") Integer limit,@Param("sellPoint") String sellPoint,@Param("title") String title,@Param("price") Long price);

	int searchItemCount(@Param("sellPoint")String sellPoint,@Param("title") String title,@Param("price") Long price);

	List<TbItem> statisticsItemCId();

	int findTbItemCountByCId(@Param("cId")Long cId);

}
