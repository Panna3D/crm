package repository;

import model.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<UserModel>{
    public List<UserModel> getAllRole(){
        //Mo connection
        //PreparaStateMent
        //excuteQuery, excuteUpdate
        return excuteQuery((connection)->{
            List<UserModel> userModels = new ArrayList<>();

            String query = "select * from users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setPassword(resultSet.getString("password"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setAvatar(resultSet.getString("avatar"));
                userModel.setRoleId(resultSet.getInt("role_id"));

                userModels.add(userModel);
            }

            return userModels;
        });
    }

}
