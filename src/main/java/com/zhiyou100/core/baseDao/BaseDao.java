package com.zhiyou100.core.baseDao;

import java.util.List;

import com.zhiyou100.pojo.Contract;
/**
 * dao�ĸ���
 * @author cm
 *
 * @param <E>
 */
public interface BaseDao<E> {
	/**
	 * ͨ��id��ѯ
	 * @param id
	 * @return
	 */
	E findById(int id);
	/**
	 * ��ӵķ���
	 */
	void add(E e);
	/**
	 * �޸���Ϣ�ķ���
	 */
	void update(E e);
	/**
	 * ɾ����Ϣ�ķ���
	 */
	void delete(int id);
	/**
	 * ��ѯ����
	 * @return
	 */
	List<E> findAll();
}
