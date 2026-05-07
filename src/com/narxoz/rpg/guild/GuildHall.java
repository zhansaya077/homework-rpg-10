package com.narxoz.rpg.guild;

public class GuildHall implements GuildMediator {

    private Quartermaster quartermaster;
    private Scout scout;
    private Healer healer;
    private Captain captain;

    public void setQuartermaster(Quartermaster quartermaster) {
        this.quartermaster = quartermaster;
    }

    public void setScout(Scout scout) {
        this.scout = scout;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    @Override
    public void send(String message, GuildMember sender) {

        String msg = message.toLowerCase();

        if (sender instanceof Scout) {
            captain.receive("Scout report: " + message);
            return;
        }

        if (msg.contains("heal")) {
            healer.receive(message);
            return;
        }

        if (msg.contains("supply")) {
            quartermaster.receive(message);
            return;
        }

        if (msg.contains("enemy")) {
            captain.receive(message);
            healer.receive("Prepare for battle!");
            return;
        }

        captain.receive(message);
    }
}
