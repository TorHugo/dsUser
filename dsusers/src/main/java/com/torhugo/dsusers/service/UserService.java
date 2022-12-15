package com.torhugo.dsusers.service;

import com.torhugo.dsusers.entity.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserService {

    UserDTO insert(final UserDTO dto);

    UserDTO findById(final Long id);

    Page<UserDTO> findAllPaged(PageRequest pageRequest);

    UserDTO update(Long id, UserDTO dto);

    void delete(Long id);
}
