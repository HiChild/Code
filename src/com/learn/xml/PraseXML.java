package com.learn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class PraseXML {
    public static void main(String[] args) throws Exception {
        InputStream input = PraseXML.class.getResourceAsStream("book.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);
        Node root = doc.getFirstChild();
        PraseXML praseXML = new PraseXML();
        praseXML.printNode(root, doc.getElementsByTagName("book").getLength());
    }

    void printNode(Node n, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(' ');
        }
        switch (n.getNodeType()) {
            case Node.DOCUMENT_NODE: // Document节点
                System.out.println("Document: " + n.getNodeName());
                break;
            case Node.ELEMENT_NODE: // 元素节点
                System.out.println("Element: " + n.getNodeName());
                break;
            case Node.TEXT_NODE: // 文本
                System.out.println("Text: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE: // 属性
                System.out.println("Attr: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            default: // 其他
                System.out.println("NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName());
        }
        for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
            printNode(child, indent + 1);
        }
    }
}
