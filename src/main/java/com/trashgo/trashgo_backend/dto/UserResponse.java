package com.trashgo.trashgo_backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class UserResponse {
    private String name;

    private Long id;

    private String profileImageUrl;

    private String email;

    public UserResponse(String name, Long id, String profileImageUrl, String email) {
        this.name = name;
        this.id = id;
        this.profileImageUrl = profileImageUrl;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getEmail() {
        return email;
    }
}
