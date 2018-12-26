package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

//import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

//	public ArrayList<ItemListDTO>getItemListInfo(String id, String item_name, String item_price, String item_stock, String insert_date, String update_date)throws SQLException{
//		ArrayList<ItemListDTO>itemListDTO=new ArrayList<ItemListDTO>();
//		String sql="SELECT FROM item_info_transaction";
//		try{
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			preparedStatement.setString(1, id);
//			preparedStatement.setString(2, item_name);
//			preparedStatement.setString(3, item_price);
//			preparedStatement.setString(4, item_stock);
//			preparedStatement.setString(5, insert_date);
//			preparedStatement.setString(6, update_date);
//
//			ResultSet resultSet=preparedStatement.executeQuery();
//
//			while(resultSet.next()){
//				ItemListDTO dto=new ItemListDTO();
//				dto.setId(resultSet.getString("id"));
//				dto.setItemName(resultSet.getString("item_name"));
//				dto.setItemPrice(resultSet.getString("item_price"));
//				dto.setItemStock(resultSet.getString("item_stock"));
//				dto.setInsert_date(resultSet.getString("insert_date"));
//				dto.setUpdate_date(resultSet.getString("update_date"));
//				itemListDTO.add(dto);
//
//			}
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			connection.close();
//		}
//		return itemListDTO;
//
//	}

//	public int itemListDelete(String id,String item_name,String item_price,String item_stock, String insert_date, String update_date)throws SQLException{
	public int itemListDelete()throws SQLException{
		String sql="DELETE FROM item_info_transaction";
//		String sql="DELETE FROM item_info_transaction WHERE item_name=? AND item_price=? AND item_stock=? AND insert_date=?";

		PreparedStatement preparedStatement;
		int result =0;
		try{
			preparedStatement=connection.prepareStatement(sql);
//			preparedStatement.setString(1, id);
//			preparedStatement.setString(2, item_name);
//			preparedStatement.setString(3, item_price);
//			preparedStatement.setString(4, item_stock);
//			preparedStatement.setString(5, insert_date);
//			preparedStatement.setString(6, update_date);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;

	}

}
