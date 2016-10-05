package pl.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileToGraphReader {
	
	private static final String PATH = "rsc/kroA100.xml";
	private static final String GRAPH = "graph";
	private static final String VERTEX = "vertex";
	private static final String COST = "cost";

	public Graph read(){
		File file = new File(PATH);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);
		} catch (ParserConfigurationException|SAXException|IOException e) {}
		
		document.getDocumentElement().normalize();
		NodeList vertexList = document.getElementsByTagName(VERTEX);
		Graph graph = new Graph();
		for(int i = 0; i < vertexList.getLength(); i++) {
			Node vertexNode = vertexList.item(i);
			NodeList edgeList = vertexNode.getChildNodes();
			Vertex vertex = new Vertex(i);
			for(int j = 0; j < edgeList.getLength(); j++) {
				Node edgeNode = edgeList.item(j);
				if(edgeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) edgeNode;
					String edgeDestination = element.getTextContent();
					String cost = element.getAttribute(COST);
					Edge edge = new Edge(Integer.parseInt(edgeDestination), Double.parseDouble(cost));
					vertex.addEdge(edge);
				}
			}
			graph.addVertex(vertex);
		}
		
		return graph;
	}
}
