package org.nodewalker;

import java.util.*;
import java.util.stream.Stream;

/**
 * Author: Richard Yang
 */
public class NodeWalkerLib {
    private static final String KEY_SEPARATOR = "/";
    private static final String NODE_NAME = "Name: ";
    private static final String NODE_DEPT = ", Depth: ";
    private static final String NODE_AGE = ", Age: ";
    private static final int ROOT_BASE = 1; // root or parent node is 1-based


    /**
     * @param node current node used as the starting point to navigate the object graph to determine the depth to the root/parent node.
     * @return depth of current node
     */
    private static int getDepth(NodeWalkerApp.Node node) {
        int depth = ROOT_BASE;

        while (node.getParentNode() != null) {
            depth++;
            node = node.getParentNode();
        }

        return depth;
    }

    /**
     *
     * @param nodeList the list that needs to be sorted by depth and age in descending orders
     */
    private static void sort(List<NodeWalkerApp.Node> nodeList) {
        Collections.sort(nodeList, new Comparator<NodeWalkerApp.Node>() {
            public int compare(NodeWalkerApp.Node node1, NodeWalkerApp.Node node2) {
                return (((getDepth(node2) - getDepth(node1)) == 0) ? (node2.getAge() - node1.getAge()) : (getDepth(node2) - getDepth(node1)));
            }
        });
    }

    /**
     * See how much Java 8 can help developer. You can re-factor more than the code below!
     * @param nodeList
     */

    private static void java8Sort(List<NodeWalkerApp.Node> nodeList) {

         nodeList.sort((node1, node2) -> (((getDepth(node2) - getDepth(node1)) == 0) ? (node2.getAge() - node1.getAge()) : (getDepth(node2) - getDepth(node1))));
    }


    /**
     *
     * @param nodeList contains the nodes that need to put into a list of Map
     * @return List<Map> re-arrange based on depth and then age in descending orders
     */
    private static List<Map> convertListNodeToListMap(List<NodeWalkerApp.Node> nodeList) {
        List<Map> nodeSortedList = new ArrayList<>();

        for (NodeWalkerApp.Node node : nodeList) {
            String key = node.getName() + KEY_SEPARATOR + getDepth(node) + KEY_SEPARATOR + node.getAge();
            Map<String, NodeWalkerApp.Node> sortedMap = new HashMap<>();
            sortedMap.put(key, node);
            nodeSortedList.add(sortedMap);
        }

        return nodeSortedList;
    }


    private static Map<String, NodeWalkerApp.Node> convertListNodeToMap(List<NodeWalkerApp.Node> nodeList) {
        Map<String, NodeWalkerApp.Node> sortedMap = new LinkedHashMap<>(16, 0.75f, false); // default initial capacitor = 16, load factor = 75%, access order = false => insertion order

        for (NodeWalkerApp.Node node : nodeList) {
            String key = node.getName() + KEY_SEPARATOR + getDepth(node) + KEY_SEPARATOR + node.getAge();
            sortedMap.put(key, node);
        }

        return sortedMap;
    }

    /**
     * Rearrange a list of nodes into a list of maps using the following Strings as keys:
     * Name/Depth/Age
     * for example in json notation this list would look like the following...
     * <p><code>[
     * {"Name":"Geo", "Depth":3, "Age":12},
     * {"Name":"Kira", "Depth":2, "Age":34},
     * {"Name":"Drosen", "Depth":2, "Age":12}
     * ]
     * </code></p>
     * The depth should be displayed as a 1-based number, with 1 being a root node.
     * <p/>
     * Order should start by greatest depth, within that depth, highest age to lowest age. Then for the next depth
     * highest age to lowest age, etc.
     *
     * @param nodeList List of nodes with links to their parent node.
     */
    public static List<Map> arrangeNodesByDepth(List<NodeWalkerApp.Node> nodeList) {
        java8Sort(nodeList);
        return convertListNodeToListMap(nodeList);

    }

    public static Map<String, NodeWalkerApp.Node> arrangeNodesByDepthAndAge(List<NodeWalkerApp.Node> nodeList) {
        sort(nodeList);
        return convertListNodeToMap(nodeList);
    }

    public static Map<NodeWalkerApp.Node, String> arrangeMapNodesByDepthAndAge(List<NodeWalkerApp.Node> nodeList) {

        Map<NodeWalkerApp.Node, String> sortedMap = new TreeMap(new Comparator<NodeWalkerApp.Node>() {
            public int compare(NodeWalkerApp.Node node1, NodeWalkerApp.Node node2) {
                int order = (((getDepth(node2) - getDepth(node1)) == 0) ?  (node2.getAge() - node1.getAge()) : (getDepth(node2) - getDepth(node1)));

                return order;
            }
        });

        for (NodeWalkerApp.Node node : nodeList) {
            String key = node.getName() + KEY_SEPARATOR + getDepth(node) + KEY_SEPARATOR + node.getAge();
            sortedMap.put(node, key);
        }

        return sortedMap;
    }



    /**
     * Print out the name of each node along with the depth & age in parenthesis.
     *
     * @param nodes List of nodes as maps.
     */
    public static void displayNodesByDepth(List<Map> nodes) {
        System.out.println("[ListMap");
        for (Map mapNode : nodes) {
            Iterator iterator = mapNode.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry)iterator.next();
                String key = (String)mapEntry.getKey();
                NodeWalkerApp.Node node = (NodeWalkerApp.Node)mapEntry.getValue();
                System.out.println("(" + NODE_NAME + node.getName() + NODE_DEPT + getDepth(node) + NODE_AGE + node.getAge() + ")");
            }
        }
        System.out.println("]");
    }


    public static void displayNodesByDepth(Map<String, NodeWalkerApp.Node> sortedMaps) {

        System.out.println("[LinkedHashMap");
        for (Map.Entry<String, NodeWalkerApp.Node> entry : sortedMaps.entrySet()) {
            String key = entry.getKey();
            NodeWalkerApp.Node node = entry.getValue();
            System.out.println("(" + NODE_NAME + node.getName() + NODE_DEPT + getDepth(node) + NODE_AGE + node.getAge() + ")");
        }
        System.out.println("]");
    }

    public static void displayMapNodesByDepth(Map<NodeWalkerApp.Node, String> sortedMaps) {

        System.out.println("[TreeMap");
        for (Map.Entry<NodeWalkerApp.Node, String> entry : sortedMaps.entrySet()) {
            NodeWalkerApp.Node node = entry.getKey();
            String key = entry.getValue();
            System.out.println("(" + NODE_NAME + node.getName() + NODE_DEPT + getDepth(node) + NODE_AGE + node.getAge() + ")");
        }
        System.out.println("]");

    }


}
