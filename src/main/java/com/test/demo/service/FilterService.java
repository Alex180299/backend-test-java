package com.test.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FilterService
{
    int counter = 0;

    public boolean filter(String s)
    {
        counter++;

        if (counter > 15000)
        {
            counter = 0;
        }

        if (counter < 5000)
        {
            return false;
        }
        else if (counter > 5000 && counter < 15000)
        {
            return true;
        }

        return true;
    }
}
