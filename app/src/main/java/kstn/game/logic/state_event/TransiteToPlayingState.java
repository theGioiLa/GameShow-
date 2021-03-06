package kstn.game.logic.state_event;

import java.util.List;

import kstn.game.logic.event.BaseEventData;
import kstn.game.logic.event.EventType;
import kstn.game.logic.model.PlayerModel;

/**
 * Created by qi on 13/11/2017.
 */

public class TransiteToPlayingState extends BaseEventData {
    public final List<PlayerModel> playerList;

    public TransiteToPlayingState(List<PlayerModel> playerList) {
        super(0);
        this.playerList = playerList;
    }

    @Override
    public EventType getEventType() {
        return StateEventType.PLAYING;
    }

    @Override
    public String getName() {
        return null;
    }
}
