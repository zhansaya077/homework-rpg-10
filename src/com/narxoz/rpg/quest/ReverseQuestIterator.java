package com.narxoz.rpg.quest;

import java.util.List;

public class ReverseQuestIterator implements QuestIterator {

    private final List<Quest> quests;
    private int index;

    public ReverseQuestIterator(List<Quest> quests) {
        this.quests = quests;
        this.index = quests.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Quest next() {
        return quests.get(index--);
    }
}
