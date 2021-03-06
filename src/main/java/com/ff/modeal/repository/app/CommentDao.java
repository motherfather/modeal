package com.ff.modeal.repository.app;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ff.modeal.vo.app.*;

@Repository("commentappdao")
public class CommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommentVo> getList(Integer shopNo) {			// 댓글 리스트 출력
		return sqlSession.selectList("comment.getList", shopNo);
	}
	
	// 댓글 리스트 입력
	public int addList(CommentVo commentVo) {
		return sqlSession.insert("comment.add", commentVo);
	}
}
