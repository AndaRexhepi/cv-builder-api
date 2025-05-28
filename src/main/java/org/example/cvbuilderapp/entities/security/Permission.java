package org.example.cvbuilderapp.entities.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"), // get
    ADMIN_WRITE("admin:write");// post, put, delete

    private final String permission;
}
