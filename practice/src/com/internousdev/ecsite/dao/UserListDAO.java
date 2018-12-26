package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	List<UserInfoDTO>userInfoDTOList=new ArrayList<UserInfoDTO>();

	public List<UserInfoDTO>select()throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT * FROM login_user_transaction";

		try{
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedstatement.executeQuery();

			while(resultSet.next()){
				UserInfoDTO userInfoDTO=new UserInfoDTO();
				userInfoDTO.setId(resultSet.getString("id"));
				userInfoDTO.setLoginId(resultSet.getString("login_id"));
				userInfoDTO.setLoginPass(resultSet.getString("login_pass"));
				userInfoDTO.setUserName(resultSet.getString("user_name"));
				userInfoDTO.setInsert_date(resultSet.getString("insert_date"));
				userInfoDTO.setUpdated_date(resultSet.getString("updated_date"));
				userInfoDTOList.add(userInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
//
		}
		return userInfoDTOList;
	}


}
