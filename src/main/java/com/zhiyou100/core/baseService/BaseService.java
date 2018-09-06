package com.zhiyou100.core.baseService;

import java.util.List;

import com.zhiyou100.pojo.Contract;
/**
 * ����service�ĸ���
 * @author cm
 *
 * @param <E>
 */
public interface BaseService<E> {
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
