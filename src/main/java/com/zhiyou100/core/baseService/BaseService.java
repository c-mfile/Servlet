package com.zhiyou100.core.baseService;

import java.util.List;

import com.zhiyou100.pojo.Contract;
/**
 * 所有service的父类
 * @author cm
 *
 * @param <E>
 */
public interface BaseService<E> {
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	E findById(int id);
	/**
	 * 添加的方法
	 */
	void add(E e);
	/**
	 * 修改信息的方法
	 */
	void update(E e);
	/**
	 * 删除信息的方法
	 */
	void delete(int id);
	/**
	 * 查询所有
	 * @return
	 */
	List<E> findAll();
}
