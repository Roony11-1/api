package com.api.api_bot.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.api_bot.dto.UserDTO;
import com.api.api_bot.interfaces.IEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "users")
@NoArgsConstructor
public class User implements IEntity<UserDTO>
{
    @Id
    private String id; // lo dejare compuesto entre discordId y serverId

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
