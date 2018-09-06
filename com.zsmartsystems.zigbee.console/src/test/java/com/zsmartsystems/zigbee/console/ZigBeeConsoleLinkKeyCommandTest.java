package com.zsmartsystems.zigbee.console;

import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeConsoleLinkKeyCommandTest {
    @Test
    public void getSyntax() {
        ZigBeeConsoleLinkKeyCommand command = new ZigBeeConsoleLinkKeyCommand();

        System.out.println(command.getSyntax());
    }
}
