package com.atguigu.surveypark.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.atguigu.surveypark.dao.BaseDao;

/**
 * �����daoʵ��,ר�����ڼ̳�
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	//ע��sessionFactory
	@Resource
	private SessionFactory sf ;
	
	private Class<T> clazz ;
	
	public BaseDaoImpl(){
		//�õ����ͻ�����
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	}

	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	/**
	 * ����HQL��������������
	 */
	public void batchEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}
	
	//ִ��ԭ����sql���
		public void executeSQL(String sql,Object...objects){
			SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
			for(int i = 0 ; i < objects.length ; i ++){
				q.setParameter(i, objects[i]);
			}
			q.executeUpdate();
		}

	public T loadEntity(Integer id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	public T getEntity(Integer id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	
	//��ֵ����,ȷ����ѯ�������ֻ��һ����¼
	public Object uniqueResult(String hql,Object...objects){
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}
	
	//ִ��ԭ����sql��ѯ
	public List executeSQLQuery(Class clazz,String sql,Object...objects){
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		//����ʵ����
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
}