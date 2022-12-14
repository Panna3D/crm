package repository;

import model.RoleModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository extends AbstractRepository<RoleModel> {

    public List<RoleModel> getAllRole(){
        //Mo connection
        //PreparaStateMent
        //excuteQuery, excuteUpdate
        return excuteQuery((connection)->{
            List<RoleModel> roleModels = new ArrayList<>();

            String query = "select * from roles";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                RoleModel roleModel = new RoleModel();
                roleModel.setId(resultSet.getInt("id"));
                roleModel.setName(resultSet.getString("name"));
                roleModel.setDescription(resultSet.getString("description"));

                roleModels.add(roleModel);
            }

            return roleModels;
        });
    }

    public Integer deleteRole(String id){
        return excuteSaveAndUpdate((connection)->{
            String query = "delete from roles where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);

            return preparedStatement.executeUpdate();
        });
    }

    public Integer updateRole(RoleModel roleModel){
        return excuteSaveAndUpdate((connection) -> {
            String query = "update roles set name=? ,description=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,roleModel.getName());
            preparedStatement.setString(2,roleModel.getDescription());
            preparedStatement.setInt(3,roleModel.getId());

            return preparedStatement.executeUpdate();
        });
    }

    public Integer createRole(RoleModel roleModel){
        return excuteSaveAndUpdate((connection) -> {
            String query = "insert into roles values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,roleModel.getId());
            preparedStatement.setString(2,roleModel.getName());
            preparedStatement.setString(3,roleModel.getDescription());
            return preparedStatement.executeUpdate();
        });
    }

}