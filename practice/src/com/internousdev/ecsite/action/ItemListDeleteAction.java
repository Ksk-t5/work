package com.internousdev.ecsite.action;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Map;

//import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteDAO;
//import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteAction extends ActionSupport
//implements SessionAware
{
//	public Map<String, Object>session;
//	private ItemListDeleteDAO itemListDeleteDAO=new ItemListDeleteDAO();
//	private ArrayList<ItemListDTO> itemListDelete=new ArrayList<ItemListDTO>();
	private String message;
//	private String deleteFlg;
//	private String itemListDeleteConfirm;

	public String execute() throws SQLException{
		String result=ERROR;
		ItemListDeleteDAO itemListDeleteDAO=new ItemListDeleteDAO();
		int res=itemListDeleteDAO.itemListDelete();
//		if(deleteFlg.equals("1")){
			if(res>0){
				setMessage("商品情報を正しく削除しました。");
			}else{
				setMessage("商品情報の削除に失敗しました。");
//			}else if()
//			try {
//				delete();
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//		}
			}
		result=SUCCESS;
		return result;
	}

//	public void delete() throws SQLException{

//		itemList=itemListDeleteDAO.getItemListInfo(item_name,item_price,item_stock,insert_date);

//		String id=session.get("id").toString();
//		String item_name=session.get("item_name").toString();
//		String item_price=session.get("item_price").toString();
//		String item_stock=session.get("item_stock").toString();
//		String insert_date=session.get("insert_date").toString();
//		String update_date=session.get("update_date").toString();

//		int res=itemListDeleteDAO.itemListDelete(id,item_name,item_price,item_stock,insert_date,update_date);
//		int res=itemListDeleteDAO.itemListDelete(item_name,item_price,item_stock,insert_date);

//		if(res>0){
////			itemListDelete=null;
//			setMessage("商品情報を正しく削除しました。");
//
//		}else if(res==0){
//			setMessage("商品情報の削除に失敗しました。");
//		}
//	}
//
//	@Override
//	public void setSession(Map<String,Object>session){
//		this.session=session;
//	}
//	public ArrayList<ItemListDTO>getItemListDelete(){
//		return this.itemListDelete;
//	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

//	public void setDeleteFlg(String deleteFlg){
//		this.deleteFlg=deleteFlg;
//	}

//	public String getItemListDeleteConfirm(){
//		return itemListDeleteConfirm;
//	}
//
//	public void setItemListDeleteConfirm(String itemListDeleteConfirm){
//		this.itemListDeleteConfirm=itemListDeleteConfirm;
//	}



}
