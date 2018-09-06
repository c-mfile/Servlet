package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.core.baseService.BaseService;
import com.zhiyou100.pojo.Rect;

public interface RectService extends BaseService<Rect> {
	List<Rect> findAll();
}
