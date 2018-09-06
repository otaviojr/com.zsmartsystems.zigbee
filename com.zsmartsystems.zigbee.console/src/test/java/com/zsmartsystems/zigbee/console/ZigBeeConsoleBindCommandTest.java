package com.zsmartsystems.zigbee.console;

import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeConsoleBindCommandTest {
    @Test
    public void getSyntax() {
        ZigBeeConsoleBindCommand command = new ZigBeeConsoleBindCommand();

        System.out.println(command.getSyntax());
    }
}
