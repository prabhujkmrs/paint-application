package com.prabhuj.paint.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DrawImpl implements Draw{

    private List<String> canvasList;
    private Integer width;
    private Integer height;

    @Override
    public void getUserInput() {
        System.out.println("Please enter the command:");
    }

    @Override
    public void processInput() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            String[] column = line.split("\\s");

            if (line.equals("Q")) {
                System.exit(0);
            }
            else {
                if (column[0].equals("C") && column.length == 3) {
                    this.validateCanvasCommand(column);
                }
                else if (column.length == 5) {
                    this.lineCommandProcessor(column);
                } else {
                    this.invalidCommand();
                }
            }
        } catch (Exception e) {
            this.invalidCommand();
        }

    }

    private void validateCanvasCommand(String[] column) {
        try {
            width = Integer.parseInt(column[1]);
            height = Integer.parseInt(column[2]);

            if (width > 0 && height > 0) {
                canvasList = this.buildCanvas();
                this.printCanvas();
            } else
                this.invalidCommand();
        } catch (Exception e) {
            this.invalidCommand();
        }
    }

    private void lineCommandProcessor(String[] column) {
        try {
            int x1 = Integer.parseInt(column[1]);
            int y1 = Integer.parseInt(column[2]);
            int x2 = Integer.parseInt(column[3]);
            int y2 = Integer.parseInt(column[4]);

            if ((x1 > 0 && y1 > 0 && x2 > 0 && y2 > 0) && (x1 <= width && x2 <= width) && (y1 <= height && y2 <= height)) {
                switch (column[0]) {
                    case "L":
                        if (x1 == x2) {
                            drawVerticalLine(x1, y1, x2, y2);
                            this.printCanvas();
                        }
                        else if (y1 == y2) {
                            drawHorizontalLine(x1, y1, x2, y2);
                            this.printCanvas();
                        } else {
                            this.invalidCommand();
                        }
                        break;
                    case "R":
                        drawHorizontalLine(x1, y1, x2, y1);
                        drawHorizontalLine(x1, y2, x2, y2);
                        drawVerticalLine(x1, y1, x1, y2);
                        drawVerticalLine(x2, y1, x2, y2);
                        this.printCanvas();
                        break;
                    default:
                        this.invalidCommand();
                        break;
                }
            } else
                this.invalidCommand();
        } catch (Exception e) {
            this.invalidCommand();
        }
    }

    private void invalidCommand() {
        System.out.println("Command Invalid. Please enter a valid command:");
    }

    private List<String> buildCanvas() {
        List<String> buildCanvas = new ArrayList<>();
        StringBuilder top = new StringBuilder(" ");
        StringBuilder side = new StringBuilder("|");
        for (int i = 0; i < width; i++) {
            top.append("-");
            side.append(" ");
        }
        side.append("|");
        buildCanvas.add(top.toString());
        for (int i = 0; i < height; i++) {
            buildCanvas.add(side.toString());
        }
        buildCanvas.add(top.toString());
        return buildCanvas;
    }

    private void printCanvas() {
        for (String canvas : canvasList) {
            System.out.println(canvas);
        }
    }

    private void drawVerticalLine(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            StringBuilder line = new StringBuilder(canvasList.get(i));
            line.setCharAt(x1, 'x');
            canvasList.set(i, line.toString());
        }
    }

    private void drawHorizontalLine(int x1, int y1, int x2, int y2) {
        StringBuilder line = new StringBuilder(canvasList.get(y1));
        for (int i = x1; i <= x2; i++)
            line.setCharAt(i, 'x');
        canvasList.set(y1, line.toString());

    }
}
