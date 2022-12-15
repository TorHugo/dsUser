package com.torhugo.dsusers.service.impl;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.entity.model.UserModel;
import com.torhugo.dsusers.exception.impl.DataBaseException;
import com.torhugo.dsusers.exception.impl.ResourceNotFoundException;
import com.torhugo.dsusers.mapper.UserMapper;
import com.torhugo.dsusers.repository.UserRepository;
import com.torhugo.dsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
        Page<UserModel> list = repository.findAll(pageRequest);
        return list.map(UserDTO::new);
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        try {
            UserModel entity = repository.getOne(id);
            entity = userUtils.mapper(dto);

            entity = repository.save(entity);

            return new UserDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation!");
        }
    }
}
