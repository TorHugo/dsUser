package com.torhugo.dsusers.service;

import com.torhugo.dsusers.entity.dto.UserDTO;

public interface UserService {

    UserDTO insert(final UserDTO dto);

    UserDTO findById(final Long id);
}
