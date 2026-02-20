package com.api.api_bot.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_bot.users.dto.UserDTO;
import com.api.api_bot.users.model.User;
import com.api.api_bot.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users/v1")
@RequiredArgsConstructor
public class UserController 
{
    private final UserService _userService;

    @GetMapping
    public ResponseEntity<UserDTO> findByDiscordIdAndServerId(
        @RequestParam String discordId,
        @RequestParam String serverId)
    {
        User user = _userService.findByDiscordIdAndServerId(discordId, serverId);
        
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody User user)
    {
        if (!isValidUser(user))
            return ResponseEntity.badRequest().build();

        User savedUser = _userService.save(user);

        return ResponseEntity.ok(new UserDTO(savedUser));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<UserDTO>> saveAll(@RequestBody List<User> users)
    {
        if (users == null || users.isEmpty())
            return ResponseEntity.badRequest().build();

        users.removeIf(user -> !isValidUser(user));

        List<User> savedUsers = _userService.saveAll(users);

        return ResponseEntity.ok(
            savedUsers
                .stream()
                .map(UserDTO::new)
                .toList());
    }

    private boolean isValidUser(User user) 
    {
        return user != null &&
            user.getServerId() != null &&
            user.getDiscordId() != null;
    }
}
