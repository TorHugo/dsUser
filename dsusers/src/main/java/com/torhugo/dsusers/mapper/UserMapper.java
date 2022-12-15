package com.torhugo.dsusers.mapper;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.entity.model.UserModel;
import com.torhugo.dsusers.exception.impl.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel mapper(final UserDTO dto){
        UserModel model = new UserModel();
        model.setName(dto.getName());
        model.setIncome(dto.getIncome());
        model.setChildren(dto.getChildren());
        model.setBirthDate(dto.getBirthDate());

        if(validateCpf(dto.getCpf()))
            model.setCpf(dto.getCpf());
        else
            return null;

        return model;
    }

    private Boolean validateCpf(final String cpf) {
        if (cpf.length() != 11)
            throw new ResourceNotFoundException("Cpf is not valid.");

        return true;
    }
}
