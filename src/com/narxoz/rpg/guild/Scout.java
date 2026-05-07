package com.narxoz.rpg.guild;

public class Scout extends GuildMember {

    public Scout(GuildMediator mediator) {
        super(mediator);
    }

    public void report(String message) {
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("Scout: " + message);
    }
}
