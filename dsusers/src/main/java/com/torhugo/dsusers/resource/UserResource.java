package com.torhugo.dsusers.resource;

import com.torhugo.dsusers.entity.dto.UserDTO;
import com.torhugo.dsusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto) throws Exception {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
