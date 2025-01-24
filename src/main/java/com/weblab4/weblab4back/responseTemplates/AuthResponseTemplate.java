package com.weblab4.weblab4back.responseTemplates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponseTemplate {
    private String message;
    private String username;
    private String token;
}
