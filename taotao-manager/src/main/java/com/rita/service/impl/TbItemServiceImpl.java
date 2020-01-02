package com.rita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rita.bean.TbItem;
import com.rita.mapper.TbItemMapper;
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

}
