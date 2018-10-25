package com.dgraciac.tictactoe;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CellCollection {

    private Set<Cell> cells;

    public CellCollection() {
        this.cells = new HashSet<>();
    }

    public CellCollection(Cell... cells) {
        this();
        this.cells.addAll(Arrays.asList(cells));
    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public boolean has(CellCollection cellCollection) {
        return cells.containsAll(cellCollection.cells);
    }

}
