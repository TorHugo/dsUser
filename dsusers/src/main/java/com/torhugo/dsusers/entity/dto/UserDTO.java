package com.torhugo.dsusers.entity.dto;

import com.torhugo.dsusers.entity.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public UserDTO(UserModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.cpf = model.getCpf();
        this.income = model.getIncome();
        this.birthDate = model.getBirthDate();
        this.children = model.getChildren();
    }
}
