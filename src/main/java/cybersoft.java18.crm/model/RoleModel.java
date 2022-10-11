package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleModel {
    private int id;
    private String name;
    private String description;
}