public class Codec {

    StringBuilder b = new StringBuilder();
// Encodes a tree to a single string.

    public String serialize(Node root) {
        if (root == null) {
            return null;
        }
        Serialize(root);
        return b.toString();
    }
// Decodes your encoded data to tree.

    public Node deserialize(String data) 
	{
        if (data == null) {
            return null;
        }
        return buildTree(data.split(","), new int[1]);
    }

    private void Serialize(Node root) {
        if (root == null) {
            b.append("#,");
            return;
        }
        b.append(root.val + ",");
        b.append(root.children.size() + ",");
        for (Node child : root.children) 
		{
            Serialize(child);
        }
    }

    private Node buildTree(String[] data, int[] index) {
        if (index[0] >= data.length || "#".equals(data[index[0]])) {
            index[0]++;
            return null;
        }
        Node root = new Node(Integer.parseInt(data[index[0]]));
        index[0]++;
        int count = Integer.parseInt(data[index[0]]);
        index[0]++;
        root.children = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            root.children.add(buildTree(data, index));
        }
        return root;
    }
}
