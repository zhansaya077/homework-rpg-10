package com.narxoz.rpg.guild;

public abstract class GuildMember {

    protected GuildMediator mediator;

    public GuildMember(GuildMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);
}
