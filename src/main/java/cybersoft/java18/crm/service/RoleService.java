package cybersoft.java18.crm.service;

import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.repository.RoleRepository;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    private static RoleService INSTANCE = null;
    private RoleRepository roleRepository = new RoleRepository();

//    public static RoleRepository getInstance () {
//        if (INSTANCE == null) {
//            INSTANCE  = new RoleService();
//        }
//        return INSTANCE;
//    }
    
    public List<RoleModel> getAllRole () throws SQLException {
        return roleRepository.getAllRole();
    }

}
