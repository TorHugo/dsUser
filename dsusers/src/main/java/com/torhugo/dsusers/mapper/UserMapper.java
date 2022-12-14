package com.torhugo.dsusers.mapper;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.entity.model.UserModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserMapper {

    public UserModel mapper(final UserDTO dto) throws Exception {
        UserModel model = new UserModel();
        model.setName(dto.getName());
        model.setIncome(dto.getIncome());
        model.setChildren(dto.getChildren());
        model.setBirthDate(dto.getBirthDate());

        if(validateCpf(dto.getCpf()))
            model.setCpf(dto.getName());
        else
            return null;

        return model;
    }

    private Boolean validateCpf(final String cpf) throws Exception {
        if (cpf.length() > 11 || cpf.length() < 1)
            throw new Exception("Cpf is not valid.");

        return true;
    }
}
