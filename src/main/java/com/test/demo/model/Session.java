package com.test.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Session
{
    private int id;
    private long approved;
    private long disapproved;
}
