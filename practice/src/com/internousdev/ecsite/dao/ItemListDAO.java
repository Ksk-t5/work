package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	List<ItemListDTO>itemListDTOList=new ArrayList<ItemListDTO>();

	public List<ItemListDTO>select()throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT * FROM item_info_transaction";

		try{
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedstatement.executeQuery();

			while(resultSet.next()){
				ItemListDTO itemListDTO=new ItemListDTO();
				itemListDTO.setId(resultSet.getString("id"));
				itemListDTO.setItemName(resultSet.getString("item_name"));
				itemListDTO.setItemPrice(resultSet.getString("item_price"));
				itemListDTO.setItemStock(resultSet.getString("item_stock"));
				itemListDTO.setInsert_date(resultSet.getString("insert_date"));
				itemListDTO.setUpdate_date(resultSet.getString("update_date"));
				itemListDTOList.add(itemListDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
//		try{
			connection.close();
//		}catch(SQLException e){
//			e.printStackTrace();
		}
		return itemListDTOList;
	}

}
