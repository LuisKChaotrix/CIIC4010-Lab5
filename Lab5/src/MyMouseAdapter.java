import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							
							
							
							

							
							
							
							
							/////////////////
							//LEFT Grey Line
							/////////////////
							if ((gridX == 0) && (gridY != 0 && gridY != 10)){
								for (int i=1; i <10; i++ ){
									Color newColor = null;						
									switch (generator.nextInt(5)) {
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][gridY] = newColor;
									myPanel.repaint();
								}
							}
							
							
							/////////////////
							//TOP Grey Line
							/////////////////
							else if ((gridX != 0) && gridY == 0){
									for (int i=1; i <10; i++ ){
										Color newColor = null;
										switch (generator.nextInt(5)) {
										case 0:
											newColor = Color.YELLOW;
											break;
										case 1:
											newColor = Color.MAGENTA;
											break;
										case 2:
											newColor = Color.BLACK;
											break;
										case 3:
											newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										case 4:
											newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
											break;
										}
										myPanel.colorArray[gridX][i] = newColor;
										myPanel.repaint();
									}
								}							
							
							
							else if (gridX == 0 && gridY == 10){
								for (int i=4; i <=6; i++ ){
									for (int j = 4; j <= 6; j++){
									Color newColor = null;
									
									switch (generator.nextInt(5)) {
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][j] = newColor;
									myPanel.repaint();
									
								}
							}
							}	
				

									
									

							else {
								for (int i = 1; i < 10; i++){
									Color newColor = null;
									
									switch (generator.nextInt(5)) {
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][i] = newColor;
									myPanel.repaint();
								}
							}
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
						
						} else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							switch (generator.nextInt(5)) {
							case 0:
								if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.YELLOW)){
									newColor = Color.MAGENTA;
									break;
								}
								newColor = Color.YELLOW;
								break;
							case 1:
								if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.MAGENTA)){
									newColor = Color.BLACK;
									break;
								}
								newColor = Color.MAGENTA;
								break;
							case 2:
								if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.BLACK)){
									newColor = new Color(0x964B00);
									break;
								}
								newColor = Color.BLACK;
								break;
							case 3:
								if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(new Color(0x964B00))){
									newColor = new Color(0xB57EDC);
									break;
								}
								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							case 4:
								if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(new Color(0xB57EDC))){
									newColor = Color.YELLOW;
									break;
								}
								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}