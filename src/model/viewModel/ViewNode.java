package model.viewModel;

import java.awt.Font;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Constants;
import model.Coordinates;
import model.Node;

public class ViewNode extends JPanel
{
	private JLabel streetName;
	private JLabel nodeImage;
	private ImageIcon inactiveImage;
	private ImageIcon activeImage;
	private boolean isActive = false;
	private Node node;

	public ViewNode(String streetName, Coordinates coordinates, Node node) throws IOException
	{
		this.node = node;
		activeImage = new ImageIcon (ImageIO.read(new File(Constants.activeNodeImagePath)));
		inactiveImage = new ImageIcon (ImageIO.read(new File(Constants.inActiveNodeImagePath)));

		nodeImage = new JLabel(inactiveImage);
		this.streetName = new JLabel(streetName);

		this.streetName.setBounds(0, 0, Constants.nodeViewSize, (int) (Constants.nodeViewSize * 0.4));
		nodeImage.setBounds(0, (int) (Constants.nodeViewSize * 0.4), Constants.nodeViewSize , (int) (Constants.nodeViewSize * 0.6));

		this.streetName.setFont(new Font(streetName, Font.PLAIN, 9));

		setBounds((coordinates.getX() * Constants.nodeViewSize) + Constants.nodeViewSize/2, (coordinates.getY() * Constants.nodeViewSize) + Constants.nodeViewSize/2, Constants.nodeViewSize, Constants.nodeViewSize);
		add(this.streetName);
		add(nodeImage);
		setVisible(true);

	}

	public void switchImage()
	{
		isActive = !isActive;

		if (isActive)
		{
			nodeImage.setIcon(activeImage);
		}
		else {
			nodeImage.setIcon(inactiveImage);
		}
	}

	public Node getNode() {
		return node;
	}

	public boolean isActive()
	{
		return isActive;
	}
}
