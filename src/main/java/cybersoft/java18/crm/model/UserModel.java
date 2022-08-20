package cybersoft.java18.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private int id;
    private String email;
    private String pasword;
    private String fullname;
    private String avatar;
    private int roleId;
}
