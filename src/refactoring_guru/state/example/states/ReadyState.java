package refactoring_guru.state.example.states;

import refactoring_guru.state.example.ui.Player;

/**
 * EN: They can also trigger state transitions in the context.
 * <p>
 * RU: Они также могут переводить контекст в другие состояния.
 */
public class ReadyState extends State {
  private static final String LOCKED = "Locked...";

  public ReadyState(Player player) {
    super(player);
  }

  @Override
  public String onLock() {
    player.changeState(new LockedState(player));
    return LOCKED;
  }

  @Override
  public String onPlay() {
    String action = player.startPlayback();
    player.changeState(new PlayingState(player));
    return action;
  }

  @Override
  public String onNext() {
    return LOCKED;
  }

  @Override
  public String onPrevious() {
    return LOCKED;
  }
}
