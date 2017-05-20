package com.yang.warrior.magicsquare.com.yang.warrior.magicsquare.rule;

import com.yang.warrior.magicsquare.RowColumn;

/**
 * Created by richardyang on 4/20/17.
 */
public class RuleThreeImpl implements Rule {
    @Override
    public RowColumn executeRule(RowColumn c, int size, boolean isNextOccupied) {
        if ((!isNextOccupied) && (c.getColumn() + 1 < size) && (c.getRow() - 1 >=0)) {
            System.out.println("Rule Three succeeds - current r/c:" + c.getRow() + "/" + c.getColumn() + " next r/c:" + (c.getRow() - 1) + "/" + c.getColumn() + 1);
            return new RowColumn(c.getRow() - 1, c.getColumn() + 1);
        }
        else {
            System.out.println("Rule Three fails - current r/c: "+ c.getRow() + "/" + c.getColumn());
            return new RowColumn(-3, -3);
        }

    }
}
