package com.api.api_bot.users.dto;

import java.time.Instant;

import com.api.api_bot.users.model.User;

import lombok.Data;

@Data
public class UserDTO 
{
    private String id;

    private String discordId;
    private String serverId;
    private boolean isBot;

    private String username;
    private String globalName;
    private String nickname;

    private boolean isOwner;
    private boolean isAdmin;

    private Instant joinedAt;
    private Instant lastSync;
    private Instant lastMenssageAt;

    private int messageCount;

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.discordId = user.getDiscordId();
        this.serverId = user.getServerId();
        this.isBot = user.isBot();
        this.username = user.getUsername();
        this.globalName = user.getGlobalName();
        this.nickname = user.getNickname();
        this.isOwner = user.isOwner();
        this.isAdmin = user.isAdmin();
        this.joinedAt = user.getJoinedAt();
        this.lastSync = user.getLastSync();
        this.lastMenssageAt = user.getLastMenssageAt();

        this.messageCount = user.getMessageCount();
    }
}
