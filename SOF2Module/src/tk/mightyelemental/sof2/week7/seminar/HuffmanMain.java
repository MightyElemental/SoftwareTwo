package tk.mightyelemental.sof2.week7.seminar;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class HuffmanMain {

	public static void main(String[] args) {
		String input = "hello world!";
		System.out.println("Input: " + input);
		Node tree = buildHuffmanTree(input);
		System.out.println(tree);
		System.out.println(tree.getCharacterCodes());

		String encoded = encodeString(input);
		System.out.println("Encod: " + encoded);
		System.out.println("Decod:" + decodeEncodedString(encoded, tree));
	}

	public static Node buildHuffmanTree(String input) {
		HashMap<Character, Integer> counts = getCharCounts(input);

		PriorityQueue<Node> pq = getQueue(counts);
		// System.out.println(pq);

		while (pq.size() >= 2) {
			Node n = new Node();
			n.addLeftNode(pq.poll());
			n.addRightNode(pq.poll());
			pq.add(n);
		}

		Node n = pq.poll();
		n.defineCodes();

		return n;
	}

	public static String encodeString(String input) {
		Node tree = buildHuffmanTree(input);
		String result = input;
		HashMap<Character, String> codes = tree.getCharacterCodes();
		for (Character c : codes.keySet()) {
			result = result.replace(c.toString(), codes.get(c));
		}
		return result;
	}

	public static String decodeEncodedString(String encoded, Node huffmanTree) {
		StringBuilder sb = new StringBuilder();
		Node curr = huffmanTree;
		for (char c : encoded.toCharArray()) {
			if (c == '0') {
				if (curr.leftChild != null) {
					curr = curr.leftChild;
				}
				if (curr.letter != 0) {
					sb.append(curr.letter);
					curr = huffmanTree;
				}
			} else if (c == '1') {
				if (curr.rightChild != null) {
					curr = curr.rightChild;
				}
				if (curr.letter != 0) {
					sb.append(curr.letter);
					curr = huffmanTree;
				}
			}
		}
		return sb.toString();
	}

	public static PriorityQueue<Node> getQueue(HashMap<Character, Integer> map) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));

		Character[] keys = map.keySet().toArray(Character[]::new);
		for (int i = 0; i < map.size(); i++) {
			Node n = new Node(keys[i]);
			n.value = map.get(keys[i]);
			pq.add(n);
		}

		return pq;
	}

	/** See https://stackoverflow.com/a/6712708/3005475 */
	public static HashMap<Character, Integer> getCharCounts(String input) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			Integer val = map.get(c);
			if (val != null) {
				map.put(c, Integer.valueOf(val + 1));
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

}

class Node {

	Node leftChild, rightChild;
	char letter;
	String code = "";
	int value = 0;

	public Node(char letter) {
		this.letter = letter;
	}

	public void defineCodes() {
		if (leftChild != null) {
			leftChild.code = code + "0";
			leftChild.defineCodes();
		}
		if (rightChild != null) {
			rightChild.code = code + "1";
			rightChild.defineCodes();
		}
	}

	public Node() {
	}

	public HashMap<Character, String> getCharacterCodes() {
		HashMap<Character, String> map = new HashMap<Character, String>();
		if (letter != 0) {
			map.put(letter, code);
		} else {
			map.putAll(leftChild.getCharacterCodes());
			map.putAll(rightChild.getCharacterCodes());
		}
		return map;
	}

	public String toString() {
		if (letter != 0) {
			return String.format("%s-%c=%d", code, letter, value);
		}
		return String.format("%s-[%s, %s]", code.isEmpty() ? "top" : code, leftChild.toString(), rightChild.toString());
	}

	public void addLeftNode(Node lc) {
		this.leftChild = lc;
		value += lc.value;
	}

	public void addLeftNode(Entry<Character, Integer> poll) {
		Node lc = new Node(poll.getKey());
		lc.value = poll.getValue();
		addLeftNode(lc);
	}

	public void addRightNode(Node rc) {
		this.rightChild = rc;
		value += rc.value;
	}

	public void addRightNode(Entry<Character, Integer> poll) {
		Node rc = new Node(poll.getKey());
		rc.value = poll.getValue();
		addRightNode(rc);
	}

}