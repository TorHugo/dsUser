package com.torhugo.dsusers.service.impl;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.entity.model.UserModel;
import com.torhugo.dsusers.mapper.UserMapper;
import com.torhugo.dsusers.repository.UserRepository;
import com.torhugo.dsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userUtils;

    @Override
    @Transactional
    public UserDTO insert(UserDTO dto) throws Exception {
        UserModel model = new UserModel();
        model = userUtils.mapper(dto);
        repository.save(model);

        return new UserDTO(model);
    }
}
