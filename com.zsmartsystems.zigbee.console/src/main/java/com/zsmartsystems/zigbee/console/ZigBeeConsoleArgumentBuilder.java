package com.zsmartsystems.zigbee.console;

/**
 * A builder class to build a {@link ZigBeeConsoleArgument} which defines the arguments required in a
 * {@link ZigBeeConsoleCommand}.
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeConsoleArgumentBuilder {
    private ZigBeeConsoleArgumentType type;
    private String name;
    private String description;
    private boolean optional;

    private ZigBeeConsoleArgumentBuilder(ZigBeeConsoleArgumentType type) {
        this.type = type;
    }

    /**
     * Sets the name of this argument.
     *
     * @param name a {@link String} defining the name
     * @return the {@link ZigBeeConsoleArgumentBuilder}
     */
    public ZigBeeConsoleArgumentBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the description of this argument.
     *
     * @param description a {@link String} defining the description
     * @return the {@link ZigBeeConsoleArgumentBuilder}
     */
    public ZigBeeConsoleArgumentBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the argument as optional.
     *
     * @return the {@link ZigBeeConsoleArgumentBuilder}
     */
    public ZigBeeConsoleArgumentBuilder isOptional() {
        this.optional = true;
        return this;
    }

    /**
     * Builds the argument.
     *
     * @return the {@link ZigBeeConsoleArgument}
     */
    public ZigBeeConsoleArgument build() {
        return new ZigBeeConsoleArgument(type, name, description, optional);
    }

    /**
     * Creates an {@link ZigBeeConsoleArgumentBuilder}. {@link #build} must be called to create the
     * {@link ZigBeeConsoleArgument}.
     *
     * @param type the {@link ZigBeeConsoleArgumentType} of this argument
     * @return the {@link ZigBeeConsoleArgumentBuilder}
     */
    public static ZigBeeConsoleArgumentBuilder create(ZigBeeConsoleArgumentType type) {
        return new ZigBeeConsoleArgumentBuilder(type);
    }

}
