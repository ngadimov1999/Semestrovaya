package com.classes;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void nameIsCorrect(){
        ViewClass vc = new ViewClass();
        Assert.assertEquals("frame0", vc.getName());
    }
}
