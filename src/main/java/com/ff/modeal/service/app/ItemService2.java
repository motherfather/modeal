package com.ff.modeal.service.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.modeal.repository.app.ItemDao2;
import com.ff.modeal.vo.ItemVo;

@Service
public class ItemService2 {

	@Autowired
	private ItemDao2 itemDao;

	public List<ItemVo> getAllItmes() {
		List<ItemVo> list = new ArrayList<ItemVo>();
		// // 가짜데이터
		// ItemVo itemvo = new ItemVo();
		// itemvo.setName( "밀크초콜릿" );
		// itemvo.setCount( 5 );
		// itemvo.setOriPrice( 2000 );
		// itemvo.setPrice( 1000 );
		// itemvo.setDiscount( 50 );
		// itemvo.setExpDate("2017-01-20 15:00:00");
		// itemvo.setPicture("im.jpg");
		// itemvo.setShopNo( 1 );
		// itemvo.setItemCategoryNo( 2 );
		// list.add( itemvo );
		return list;
	}

	// 해당 매장의 상품 목록
	public List<Map<String, Object>> shopItemList(Long shopNo) {
		return itemDao.shopItemList(shopNo);
	}

	// 상품 등록
	public void itemInsert(ItemVo itemVo) {
		itemDao.itemInsert(itemVo);
	}

	 // 상품 수정 - 기존에 입력한 정보 출력
	 public ItemVo itemModify(Long no) {
		 return itemDao.itemModify(no);
	 }

	 // 상품 수정 - 업데이트(갱신)
	 public void itemModifyUpdate(Map<String, Object> map){
		 itemDao.itemModifyUpdate(map);
	 }
	 
	// 상품 삭제
	public void itemDelete(Long no) {
		itemDao.itemDelete(no);
	}

	// 상품 상세 정보
	public Map<String, Object> itemDetail(String latitude, String longitude, Long no) {
		return itemDao.itemDetail(latitude, longitude, no);
	}

	// 상품 보이기/숨기기
	public void itemView(Long no, Long check) {
		itemDao.itemView(no, check);
	}
}
