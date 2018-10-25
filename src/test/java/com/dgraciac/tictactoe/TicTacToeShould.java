package com.dgraciac.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeShould {
    private TicTacToe ticTacToe;
//    private TicTacToe.State initialState;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void start_with_player_X() {
        assertThat(ticTacToe.isTurnOfPlayerX()).isTrue();
    }

    @Test
    public void alternate_players() {
        ticTacToe.play(Cell.BOTTOM_LEFT);

        assertThat(ticTacToe.isTurnOfPlayerO()).isTrue();

        ticTacToe.play(Cell.TOP_RIGHT);

        assertThat(ticTacToe.isTurnOfPlayerX()).isTrue();
    }

    @Test
    public void proclaim_X_as_winner_when_X_completes_line_first() {
        ticTacToe.play(Cell.TOP_LEFT);
        ticTacToe.play(Cell.MIDDLE_LEFT);
        ticTacToe.play(Cell.TOP_CENTER);
        ticTacToe.play(Cell.BOTTOM_LEFT);
        ticTacToe.play(Cell.TOP_RIGHT);

        assertThat(ticTacToe.hasPlayerXWon()).isTrue();
    }

    @Test
    public void proclaim_O_as_winner_when_O_completes_line_first() {
        ticTacToe.play(Cell.MIDDLE_LEFT);
        ticTacToe.play(Cell.TOP_LEFT);
        ticTacToe.play(Cell.BOTTOM_LEFT);
        ticTacToe.play(Cell.TOP_CENTER);
        ticTacToe.play(Cell.MIDDLE_RIGHT);
        ticTacToe.play(Cell.TOP_RIGHT);

        assertThat(ticTacToe.hasPlayerOWon()).isTrue();
    }

    @Test
    public void proclaim_X_as_winner() {
        ticTacToe.play(Cell.BOTTOM_LEFT);
        ticTacToe.play(Cell.TOP_LEFT);
        ticTacToe.play(Cell.BOTTOM_CENTER);
        ticTacToe.play(Cell.TOP_RIGHT);
        ticTacToe.play(Cell.BOTTOM_RIGHT);

        assertThat(ticTacToe.hasPlayerXWon()).isTrue();
    }

    @Test
    @Ignore
    public void not_proclaim_O_as_winner_when_X_wins() {
        ticTacToe.play(Cell.BOTTOM_LEFT);
        ticTacToe.play(Cell.TOP_LEFT);
        ticTacToe.play(Cell.BOTTOM_CENTER);
        ticTacToe.play(Cell.TOP_RIGHT);
        ticTacToe.play(Cell.BOTTOM_RIGHT);

        assertThat(ticTacToe.hasPlayerOWon()).isFalse();
    }
}
