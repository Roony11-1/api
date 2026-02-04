package com.api.api_bot.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.api_bot.model.User;
import com.api.api_bot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService 
{
    private final UserRepository _userRepository;

    public User findByDiscordIdAndServerId(String discordId, String serverId) 
    {
        return _userRepository.findByDiscordIdAndServerId(discordId, serverId)
            .orElseThrow(() -> new RuntimeException(
                "No se ha encontrado un usuario con discordId: " + discordId + " y serverId: " + serverId));
    }

    public List<User> saveAll(List<User> users)
    {
        users.forEach(u -> 
        {
            setIdIfAbsent(u);
            u.setLastSync(Instant.now());
        });

        return _userRepository.saveAll(users);
    }

    public User save(User user)
    {
        if (user == null) 
            return null;
        
        setIdIfAbsent(user);
        user.setLastSync(Instant.now());

        return _userRepository.save(user);
    }

    private void setIdIfAbsent(User user) 
    {
        if (user.getId() == null || user.getId().isEmpty()) 
            user.setId(user.getServerId() + ":" + user.getDiscordId());
    }
}
