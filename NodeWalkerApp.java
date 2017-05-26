package org.nodewalker;

import java.util.*;

import static org.nodewalker.NodeWalkerLib.displayNodesByDepth;
import static org.nodewalker.NodeWalkerLib.displayMapNodesByDepth;


/**
 * Author: Richard Yang
 */
public class NodeWalkerApp {

 public static void main(String ... a) {

        List<Node> nodes = generateNodes();

        long startTime = System.currentTimeMillis();
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepth(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepth(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepth(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepth(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepth(generateNodes()));
        long endTime = System.currentTimeMillis();
        System.out.println("Startime One: " + startTime + ", endTime: " + endTime + ", Duration in mill: " + (endTime - startTime));
        long startTime2 = System.currentTimeMillis();
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepthAndAge( generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepthAndAge(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepthAndAge(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepthAndAge(generateNodes()));
        displayNodesByDepth(NodeWalkerLib.arrangeNodesByDepthAndAge(generateNodes()));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Startime Two: " + startTime2 + ", endTime: " + endTime2 + ", Duration in mill: " + (endTime2 - startTime2));

        long startTime3 = System.currentTimeMillis();
        displayMapNodesByDepth(NodeWalkerLib.arrangeMapNodesByDepthAndAge(generateNodes()));
        displayMapNodesByDepth(NodeWalkerLib.arrangeMapNodesByDepthAndAge(generateNodes()));
        displayMapNodesByDepth(NodeWalkerLib.arrangeMapNodesByDepthAndAge(generateNodes()));
        displayMapNodesByDepth(NodeWalkerLib.arrangeMapNodesByDepthAndAge(generateNodes()));
        displayMapNodesByDepth(NodeWalkerLib.arrangeMapNodesByDepthAndAge(generateNodes()));
        long endTime3 = System.currentTimeMillis();
        System.out.println("Startime Three: " + startTime3 + ", endTime: " + endTime3 + ", Duration in mill: " + (endTime3 - startTime3));
    }

    private static List<Node> generateNodes() {
        Node vN0 = new Node("vN0", null, 3);
        Node vN2 = new Node("vN2", vN0, 44);
        Node vN6 = new Node("vN6", vN2, 23);
        Node vN7 = new Node("vN7", vN6, 51);
        Node vN1 = new Node("vN1", vN0, 9);
        Node vN8 = new Node("vN8", vN0, 31);
        Node vN9 = new Node("vN9", vN8, 47);
        Node vN5 = new Node("vN5", null, 83);
        Node vN3 = new Node("vN3", vN5, 13);
        Node vN4 = new Node("vN4", vN3, 65);

        return new ArrayList<>(Arrays.asList(vN0, vN6, vN1, vN3, vN4, vN2, vN5, vN7, vN8, vN9));
    }

    public static class Node {
        private String name;
        private Node parentNode; // Null for root node
        private int age;

        public Node(String name, Node parentNode, int age) {
            this.name = name;
            this.parentNode = parentNode;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        /*
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (age != node.age) return false;
            if (name != null ? !name.equals(node.name) : node.name != null) return false;
            if (parentNode != null ? !parentNode.equals(node.parentNode) : node.parentNode != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (parentNode != null ? parentNode.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }

        */
    }
}
