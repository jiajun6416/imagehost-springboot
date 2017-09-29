package com.jiajun.common.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiajun.common.bo.Page;

public abstract class BaseDao<T> extends SqlSessionDaoSupport {

	private static final String DEFAULT_PAGE_COUNT_STATEMENT = "selectPageCount";
	private static final String DEFAILT_PAGE_LIST_STATEMENT = "selectPageList";

	protected abstract String getNamespace();

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public final int deleteByPrimaryKey(Object id) {
		return this.getSqlSession().delete(getNamespace() + "." + "deleteByPrimaryKey", id);
	}

	public final T selectByPrimaryKey(Object id) {
		return this.getSqlSession().selectOne(getNamespace() + "." + "selectByPrimaryKey", id);
	}

	public final int insert(T t) {
		return this.getSqlSession().insert(getNamespace() + "." + "insert", t);
	}

	public final int insertSelective(T t) {
		return this.getSqlSession().insert(getNamespace() + "." + "insertSelective", t);
	}

	public final int updateByPrimaryKey(T t) {
		return this.getSqlSession().update(getNamespace() + "." + "updateByPrimaryKey", t);
	}

	public final int updateByPrimaryKeySelective(T t) {
		return this.getSqlSession().update(getNamespace() + "." + "updateByPrimaryKeySelective", t);
	}

	/**
	 * 分页查询
	 * @param page
	 * @param countStatement 查询总个数sql
	 * @param listStatement list sql @
	 */
	public final void page(Page<T> page, String countStatement, String listStatement) {
		Map<String, Object> conditions = page.getConditions();
		int count = (int) selectObject(countStatement, conditions);
		page.setCount(count);
		if (count > 0) {
			int pageSize = page.getPageSize();
			int begin = (page.getCurrentPage() - 1) * pageSize;
			conditions.put("begin", begin);
			conditions.put("pageSize", pageSize);
			List<T> list = selectList(listStatement, conditions);
			page.setList(list);
			int totalPage = (count - 1) / page.getPageSize() + 1;
			page.setTotalPage(totalPage);
			conditions.remove("begin");
			conditions.remove("pageSize");
		}
	}

	/**
	 * 使用默认的查询语句
	 * @countStatement: selectPageCount
	 * @listStatement: selectPageList
	 * @param page @
	 */
	public final void page(Page<T> page) {
		this.page(page, DEFAULT_PAGE_COUNT_STATEMENT, DEFAILT_PAGE_LIST_STATEMENT);
	}

	protected final int insert(String statement, Object obj) {
		return this.getSqlSession().insert(getNamespace() + "." + statement, obj);
	}

	protected final int delete(String statement, Object obj) {
		return this.getSqlSession().delete(getNamespace() + "." + statement, obj);
	}

	protected final int update(String statement, Object obj) {
		return this.getSqlSession().update(getNamespace() + "." + statement, obj);
	}

	protected final <E> List<E> selectList(String statement, Object obj) {
		return this.getSqlSession().selectList(getNamespace() + "." + statement, obj);
	}

	protected final Object selectObject(String statement, Object obj) {
		return this.getSqlSession().selectOne(getNamespace() + "." + statement, obj);
	}

	protected final <E> void batchInsert(String statement, List<E> list) {
		for (Object object : list) {
			this.getSqlSession().insert(getNamespace() + "." + statement, object);
		}
	}

	protected final <E> void batchUpdate(String statement, List<E> list) {
		for (Object object : list) {
			this.getSqlSession().update(getNamespace() + "." + statement, object);
		}
	}

	protected final <E> void batchDelete(String statement, List<E> list) {
		for (Object object : list) {
			this.getSqlSession().delete(getNamespace() + "." + statement, object);
		}
	}
}
