package com.torhugo.dsusers.service.impl;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.entity.model.UserModel;
import com.torhugo.dsusers.exception.impl.ResourceNotFoundException;
import com.torhugo.dsusers.mapper.UserMapper;
import com.torhugo.dsusers.repository.UserRepository;
import com.torhugo.dsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userUtils;

    @Override
    @Transactional
    public UserDTO insert(UserDTO dto){
        UserModel model = new UserModel();
        model = userUtils.mapper(dto);
        repository.save(model);

        return new UserDTO(model);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<UserModel> obj = repository.findById(id);
        UserModel model = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));

        return new UserDTO(model);
    }
}
