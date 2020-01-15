package com.rita.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rita.bean.TbItem;
import com.rita.bean.TbItemCat;
import com.rita.mapper.TbItemCatMapper;
import com.rita.mapper.TbItemMapper;
import com.rita.result.EchartsResult;
import com.rita.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	private String name;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public List<EchartsResult> statisticsItem() {
		List<EchartsResult> results = new ArrayList<EchartsResult>();
		List<TbItem> tbItems = tbItemMapper.statisticsItemCId();
		for (TbItem tbItem : tbItems) {
			EchartsResult result = new EchartsResult();
			TbItemCat tbItemCat = tbItemCatMapper.getTbItemCatById(tbItem.getcId());
			getFirstItemCat(tbItemCat);
			result.setName(name+"类");
			int value =tbItemMapper.findTbItemCountByCId(tbItem.getcId());
			result.setValue(value);
			results.add(result);
		}
		return results;
	}
	private String getFirstItemCat(TbItemCat tbItemCat) {
		TbItemCat cat = tbItemCatMapper.getTbItemCatById(tbItemCat.getParentId());
		if (cat!=null) {
			name = cat.getName();
			getFirstItemCat(cat);
		}
		return null;
	}
}
