package com.example.cola.client.dto.auth;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginCmd extends Command {
    private String username;
    private String password;
}
