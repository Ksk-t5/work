package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private List<ItemListDTO>itemListDTOList=new ArrayList<ItemListDTO>();
	private Map<String,Object>session;

	public String execute() throws SQLException{
//		String ret=ERROR;
		    ItemListDAO itemListDAO=new ItemListDAO();
		    itemListDTOList=itemListDAO.select();
		    if(itemListDTOList.size()>0){
				session.put("itemListDTOList", itemListDTOList);
			}
		    String result=SUCCESS;
		return result;
	}

//		itemListDTOList=itemListDAO.select();
//
//		if(itemListDTOList.size()>0){
//			session.put("itemListDTOList", itemListDTOList);
//			ret=SUCCESS;
//		}
//		return ret;
//
//	}

	public Map<String, Object>getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public List<ItemListDTO>getItemListDTOList(){
		return itemListDTOList;
	}

	public void setItemListDTOList(List<ItemListDTO>itemListDTOList){
		this.itemListDTOList=itemListDTOList;
	}

}
