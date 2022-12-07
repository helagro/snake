package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Game;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {

    GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");
        NormalText time = new NormalText("Elapsed time: "); // end screen elapsed time text

        JButton TryAgain = new JButton();
        TryAgain.setText("Try Again");
        TryAgain.addActionListener(e -> {
            doGameOver();
        });

        JButton ChooseDifficulty = new JButton();
        ChooseDifficulty.setText("Choose Difficulty Level");
        ChooseDifficulty.addActionListener(e -> doRestartDifficulty());

        contentContainer.add(headerText);
        contentContainer.add(time);
        contentContainer.add(TryAgain);
        contentContainer.add(ChooseDifficulty);
        add(contentContainer);
    }

    public void showPanel(){
        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false);
        Game.getInstance().start();
    }
    public void doRestartDifficulty(){
        setVisible(false);
        DifficultyFrame gameOverRestartDifficulty = new DifficultyFrame();
    }
}
