package com.rita.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rita.bean.TbItem;
import com.rita.bean.TbItemCat;

public interface TbItemCatMapper {

	TbItemCat getTbItemCatById(@Param("id")Long id);


}
