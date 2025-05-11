package com.weblab4.weblab4back.responseTemplates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PointResponseTemplate {
    private double x;
    private double y;
    private double r;
    private boolean hitResult;
    private String username;
}
