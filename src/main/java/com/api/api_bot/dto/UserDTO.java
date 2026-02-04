package com.api.api_bot.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Builder
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
}
