package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.Constants;
import model.Node;
import model.Session;
import model.viewModel.ViewNode;

public class RouteCityApplication extends JFrame{

	private ArrayList<ViewNode> viewNodes = new ArrayList<>();


	public RouteCityApplication() throws IOException
	{
		initializeMainFrame();
	}

	private void initializeMainFrame() throws IOException
	{
		setTitle("Route City");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constants.mainFrameMaxX, Constants.mainFrameMaxY);
		setLayout(null);
		setResizable(false);

		setLocationRelativeTo(null);
		initializeAllNodes();
		setVisible(true);
	}

	private void initializeAllNodes() throws IOException
	{
		for (Node node : Session.getSession().getLoadedNodes())
		{
			ViewNode viewNode = new ViewNode(node.getStreetName(), node.getCoordinates(), node);

			viewNode.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					if (e.getButton() == 1)
					{
						System.out.println("You clicked node " + node.getStreetName());
						Session.getSession().setSelectedNode(node);
						viewNode.switchImage();

						for (ViewNode viewNode : viewNodes)
						{
							if (Session.getSession().getSelectedStartNode() == null || Session.getSession().getSelectedEndNode() == null)
							{
								break;
							}
							if (!Session.getSession().getSelectedStartNode().equals(viewNode.getNode()) && !Session.getSession().getSelectedEndNode().equals(viewNode.getNode()) && viewNode.isActive())
							{
								viewNode.switchImage();
							}
						}
					}
				}
			});

			viewNodes.add(viewNode);
			add(viewNode);
		}
	}

}
