package com.narxoz.rpg.quest;

import java.util.List;

public class OrderedQuestIterator implements QuestIterator {

    private final List<Quest> quests;
    private int index = 0;

    public OrderedQuestIterator(List<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public boolean hasNext() {
        return index < quests.size();
    }

    @Override
    public Quest next() {
        return quests.get(index++);
    }
}
