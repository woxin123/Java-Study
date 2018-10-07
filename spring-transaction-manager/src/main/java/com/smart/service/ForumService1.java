package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import com.smart.dao.ForumDao;
import com.smart.domain.Forum;

/**
 * 编程式事务管理
 * 通过使用TransactionTemplate模板类
 */
@Service
public class ForumService1 {
	public ForumDao forumDao;
	public TransactionTemplate template;
	public void addForum(final Forum forum) {
		// 通过execute方法执行
		template.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				forumDao.addForum(forum);
			}
		});

	}

	@Autowired
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	/**
	 * 通过下面的这个方法设置模板
	 * @param template
	 */
	@Autowired
	public void setTemplate(TransactionTemplate template) {
		this.template = template;
	}

	
	
}
