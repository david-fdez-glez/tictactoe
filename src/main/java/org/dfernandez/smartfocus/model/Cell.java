package org.dfernandez.smartfocus.model;


public class Cell {

    private Mark content;

    public Cell() {
        clear();
    }

    public void clear() {
        this.content = Mark.BLANK;
    }

    public void setContent(Mark content) {
        this.content = content;
    }

    public Mark getContent() {

        return content;
    }


    public void paint() {
        switch (content) {
            case BLANK:
                System.out.print("     ");
                break;
            case NOUGHT:
                System.out.print("  O  ");
                break;
            case CROSS:
                System.out.print("  X  ");
                break;

        }
    }
}
