package assignment7;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToolTest {

    @Test
    public void setStrength() {
        Tool tool = new Tool(20);
        tool.setStrength(10);
        assertEquals(tool.getStrength(), 10, 0);
    }

    @Test
    public void getStrength() {
        Tool tool = new Tool(20);
        assertEquals(tool.getStrength(), 20, 0);
    }
}