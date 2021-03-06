package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO boardvo = new BoardVO();
		boardvo.setTitle("새로 작성하는 글");
		boardvo.setContent("새로 작성하는 내용");
		boardvo.setWriter("newbie");
		
		mapper.insert(boardvo);
		
		log.info(boardvo);
	}
	@Test
	public void testRead() {
		
		BoardVO boardvo = mapper.read(5L);
		
		log.info(boardvo);
		
	}
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
}
