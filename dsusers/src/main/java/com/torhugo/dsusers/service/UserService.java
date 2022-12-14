package com.torhugo.dsusers.service;

import com.torhugo.dsusers.entity.dto.UserDTO;

public interface UserService {

    public UserDTO insert(final UserDTO dto) throws Exception;
}
