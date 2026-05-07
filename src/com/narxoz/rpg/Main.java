package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        // =========================
        // 1. HEROES
        // =========================
        Hero arlan = new Hero("Arlan", 100);
        Hero maya = new Hero("Maya", 90);

        // =========================
        // 2. QUEST LOG (5 quests)
        // =========================
        QuestLog log = new QuestLog();

        log.add(new Quest("Kill goblins", QuestPriority.HIGH));
        log.add(new Quest("Collect herbs", QuestPriority.LOW));
        log.add(new Quest("Defend village", QuestPriority.HIGH));
        log.add(new Quest("Scout forest", QuestPriority.MEDIUM));
        log.add(new Quest("Deliver supplies", QuestPriority.LOW));

        // =========================
        // 3. GUILD + MEDIATOR
        // =========================
        GuildHall hall = new GuildHall();

        Scout scout = new Scout(hall);
        Healer healer = new Healer(hall);
        Quartermaster quartermaster = new Quartermaster(hall);
        Captain captain = new Captain(hall);

        hall.setScout(scout);
        hall.setHealer(healer);
        hall.setQuartermaster(quartermaster);
        hall.setCaptain(captain);

        // =========================
        // 4. ITERATOR DEMO
        // =========================
        System.out.println("\n--- Ordered Quests ---");
        QuestIterator it1 = log.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next().getTitle());
        }

        System.out.println("\n--- Reverse Quests ---");
        QuestIterator it2 = log.reverseIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().getTitle());
        }

        System.out.println("\n--- HIGH Priority Quests ---");
        QuestIterator it3 = log.priorityIterator(QuestPriority.HIGH);
        while (it3.hasNext()) {
            System.out.println(it3.next().getTitle());
        }

        // =========================
        // 5. MEDIATOR DEMO
        // =========================
        System.out.println("\n--- Guild Communication ---");

        scout.report("Enemy spotted in forest");
        healer.receive("Need heal after battle");
        quartermaster.receive("Supplies are low");
        captain.receive("Prepare for war council");

        // =========================
        // 6. COUNCIL ENGINE
        // =========================
        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.run(arlan);

        System.out.println("\n=== Council Result ===");
        System.out.println(result);
    }
}
