package gui;
/*
 * by fzauleck, 25.10.2016
 */


import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Game extends Frame {
	private Label yourChoice, cLabel, pLabel, msg;
	private TextField pScore, cScore;
	private CheckboxGroup cbg;
	private Checkbox rock,paper,scissors,lizard,spock;
	private TextArea txtArea;
	private Button play, okButton;
	private Dialog dialog;	
	private int playerScore,computerScore;
	
	public Game() {
		setLayout(new FlowLayout());
		yourChoice = new Label("Your choice: ");
		pLabel = new Label("Player's Score ");
		cLabel = new Label("Computer's Score ");
		play = new Button("RockPaperScissorsLizardSpock!!");
		pScore = new TextField();
		cScore = new TextField();
		cbg = new CheckboxGroup();
		rock = new Checkbox("Rock", cbg, false);
		paper = new Checkbox("Paper", cbg, false);
		scissors = new Checkbox("Scissors", cbg, false);
		lizard = new Checkbox("Lizard", cbg, false);
		spock = new Checkbox("Spock", cbg, false);
		txtArea = new TextArea("Result:\n");
		
		
		okButton = new Button("OK");
		msg = new Label();
		dialog = new Dialog(this, "Game Over", Dialog.ModalityType.DOCUMENT_MODAL);
		dialog.setLayout(new FlowLayout());
		dialog.add(msg);
		dialog.setSize(300, 100);
		okButton.setSize(20, 10);
		
		txtArea.setEditable(false);
		pScore.setEditable(false);
		cScore.setEditable(false);
		//add to container
		add(yourChoice);
		
		add(rock);
		add(paper);
		add(scissors);
		add(lizard);
		add(spock);
		
		add(txtArea);
		
		add(play);
		
		add(pLabel);
		add(pScore);
		add(cLabel);
		add(cScore);
		
	
		setTitle("RockPaperScissorsLizardSpock!!");
        setSize(400, 600);
        setVisible(true);
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerScore = 0;
				computerScore = 0;
				pScore.setText("0");
				cScore.setText("0");
				txtArea.setText("Result:\n");
				dialog.dispose();
			}
			
		});
		dialog.add(okButton);
		dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
				
		play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String winner = "", rand = rand();
                if (rand == "ROCK") {
                	if (lizard.getState() == true ) {
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose LIZARD\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (scissors.getState() == true){
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose SCISSORS\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (spock.getState() == true) {
                		pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose SPOCK\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else if (paper.getState() == true) {
                		pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose PAPER\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else {
                		txtArea.setText("Player chose ROCK\n" + "Computer chose " + rand + "\n\n" + "Draw.\n\n");
                	}
                }else if (rand == "PAPER") {
                    	if (lizard.getState() == true ) {
                    		pScore.setText(Integer.toString(++playerScore));
                    		txtArea.setText("Player chose LIZARD\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                    	} else if (scissors.getState() == true){
                    		pScore.setText(Integer.toString(++playerScore));
                    		txtArea.setText("Player chose SCISSORS\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                    	} else if (spock.getState() == true) {
                    		cScore.setText(Integer.toString(++computerScore));
                    		txtArea.setText("Player chose SPOCK\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                    	} else if (rock.getState() == true) {
                    		cScore.setText(Integer.toString(++computerScore));
                    		txtArea.setText("Player chose ROCK\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                    	} else {
                    		txtArea.setText("Player chose PAPER\n" + "Computer chose " + rand + "\n\n" + "Draw.\n\n");
                    	}
                } else if (rand == "SCISSORS") {
                	if (lizard.getState() == true ) {
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose LIZARD\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (paper.getState() == true){
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose PAPER\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (spock.getState() == true) {
                		pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose SPOCK\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else if (rock.getState() == true) {
                	    pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose ROCK\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else {
                		txtArea.setText("Player chose SCISSORS\n" + "Computer chose " + rand + "\n\n" + "Draw.\n\n");
                	}
                }
                else if (rand == "LIZARD") {
                	if (paper.getState() == true ) {
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose PAPER\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (spock.getState() == true){
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose SPOCK\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (scissors.getState() == true) {
                		pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose SCISSORS\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else if (rock.getState() == true) {
                	    pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose ROCK\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else {
                		txtArea.setText("Player chose LIZARD\n" + "Computer chose " + rand + "\n\n" + "Draw.\n\n");
                	}
                } else if (rand == "SPOCK") {
                	if (paper.getState() == true ) {
                		pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose PAPER\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else if (lizard.getState() == true){
                	 pScore.setText(Integer.toString(++playerScore));
                		txtArea.setText("Player chose LIZARD\n" + "Computer chose " + rand + "\n\n" + "Player wins.\n\n");
                	} else if (scissors.getState() == true) {
                		cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose SCISSORS\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else if (rock.getState() == true) {
                	    cScore.setText(Integer.toString(++computerScore));
                		txtArea.setText("Player chose ROCK\n" + "Computer chose " + rand + "\n\n" + "Computer wins.\n\n");
                	} else {
                		txtArea.setText("Player chose SPOCK\n" + "Computer chose " + rand + "\n\n" + "Draw.\n\n");
                	}
                }
                if (playerScore == 5 || computerScore == 5) {
                	
                	if (playerScore > computerScore) {
            			winner = "PLAYER";
            		} else {
            			winner = "COMPUTER";
            		}
                	msg.setText("Game Over!!\n "+winner+" won.");
            		dialog.setVisible(true);

                }
            }
        });
      
	}
	
	public String rand() {
		Random rand = new Random();
		int randomNum = rand.nextInt(5) + 1;
		String result = "";
		if (randomNum == 1) {
			result = "ROCK";
		} else if (randomNum == 2) {
			result = "PAPER";
		} else if (randomNum == 3) {
			result = "SCISSORS";
		} else if (randomNum == 4) {
			result = "LIZARD";
		} else {
			result = "SPOCK";
		}
		return result;
	}
	public static void main(String[] args) {

        new Game();
    }
}