package com.dgraciac.tictactoe;

public class TicTacToe {
    private CellCollection playHistoryX;
    private State state;
    private CellCollection playHistoryO;

    public TicTacToe() {
        playHistoryX = new CellCollection();
        playHistoryO = new CellCollection();
        state = State.PLAYING_X;
    }

    private void swapPlayers(){
        state = state.equals(State.PLAYING_X) ? State.PLAYING_O : State.PLAYING_X;
    }

    public boolean isTurnOfPlayerX() {
        return state.equals(State.PLAYING_X);
    }

    public boolean isTurnOfPlayerO() {
        return state.equals(State.PLAYING_O);
    }

    public void play(Cell cell) {
        if (state.equals(State.PLAYING_X)) {
            playHistoryX.add(cell);
        } else {
            playHistoryO.add(cell);
        }
        swapPlayers();
    }

    public boolean hasPlayerXWon() {
        CellCollection topLine = new CellCollection(Cell.TOP_LEFT, Cell.TOP_CENTER, Cell.TOP_RIGHT);
        CellCollection bottomLine = new CellCollection(Cell.BOTTOM_LEFT, Cell.BOTTOM_CENTER, Cell.BOTTOM_RIGHT);
        return playHistoryX.has(topLine) || playHistoryX.has(bottomLine);
    }

    public boolean hasPlayerOWon() {
        CellCollection winningLine = new CellCollection(Cell.TOP_LEFT, Cell.TOP_CENTER, Cell.TOP_RIGHT);
        return playHistoryO.has(winningLine);
    }

    public enum State {
        PLAYING_O,
//        X_WINS,
        PLAYING_X
    }
}
