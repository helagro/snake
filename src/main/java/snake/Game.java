package snake;

import java.util.concurrent.TimeUnit;


public class Game implements Runnable{

    //Variables
    private static int TICK_SPEED = 200; // in milliseconds
    private final GamePanel gamePanel;
    int score;
    final Snake snake = new Snake(GamePanel.GRID_WIDTH/2, GamePanel.GRID_HEIGHT/2);
    final Apple apple = new Apple();
    

    //Constructor
    public Game(){
        final GUI gui = new GUI();
        gui.render();
        gamePanel = gui.addGamePanel(snake, apple);
    }


    //Methods

    public void start(){
        Thread thread = new Thread(this); // Game.java implements Runnable
        thread.start();
    }

    //This method will run in a different thread. The game window will be unresponsive otherwise.
    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(TICK_SPEED);
                doGameTick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGameTick(){
        snake.movement();
        if(snake.hasCollided(gamePanel)){
            throw new RuntimeException("Game Over not implemented yet");
        }
        if(snake.canEat(apple)){
            snake.eat(apple, gamePanel);
        }
        gamePanel.repaint();
    }
    

    //Score Calculation
    public int scoreCalc(){
        return 0;
    }
}
