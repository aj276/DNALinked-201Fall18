
public class LinkStrand implements IDnaStrand {
	private class Node {
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	private Node myFirst,myLast;
	private long mySize;
	private int myAppends;
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	
	/**
	 * Creates a new LinkStrand by calling the LinkStrand constructor
	 * with an empty String passed as the argument
	 */
	public LinkStrand()
	{
		this("");
	}
	
	/**
	 * Creates a new LinkStrand by calling the initialize method with
	 * a String as an argument
	 * @param s is the String that the LinkStrand should be initialized with
	 */
	public LinkStrand(String s)
	{
		initialize(s);
	}
	@Override
	/**
	 * Returns the size of the LinkStrand
	 * @return size of LinkStrand
	 */
	public long size() {
		// TODO Auto-generated method stub
		return mySize;
	}

	@Override
	/**
	 * Initializes the LinkStrand, initializing the first node and
	 * resetting the instance variables
	 * @param source is the String that should be the value of the first node
	 */
	public void initialize(String source) {
		// TODO Auto-generated method stub
		myFirst = new Node(source);
		myLast = null;
		myAppends = 0;
		mySize=source.length();
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}

	@Override
	/**
	 * Returns a LinkStrand with the value of the String
	 * @param source is the String that should be the value of the LinkStrand
	 * @return new LinkStrand with the value passed as an argument
	 */
	public IDnaStrand getInstance(String source) {
		// TODO Auto-generated method stub
		return new LinkStrand(source);
	}

	@Override
	/**
	 * Adds the String passed as an argument to a new Node to the
	 * existing LinkStrand
	 * @param dna is the String that is the value of the new Node
	 * @return the updated LinkStrand
	 */
	public IDnaStrand append(String dna) {
		// TODO Auto-generated method stub
		if (myLast ==null)
		{
			myLast = new Node(dna);
			myFirst.next = myLast;

		}
		else
		{
			myLast.next = new Node(dna);
			myLast = myLast.next;
		}
		mySize+=dna.length();
		myAppends++;
		return this;
	}

	@Override
	/**
	 * Reverses all the nodes in the LinkStrand as well as the values
	 * in the nodes, returning a new LinkStrand that is the reverse of
	 * the old LinkStrand
	 * @return a new LinkStrand that is the reverse of the old LinkStrand
	 */
	public IDnaStrand reverse() {
		// TODO Auto-generated method stub
		if (myFirst==null)
			return new LinkStrand();

		Node n = myFirst;
		StringBuilder s = new StringBuilder(myFirst.info);
		LinkStrand answer1 = new LinkStrand(s.reverse().toString());
		n=n.next;
		while (n!=null)
		{
			s = new StringBuilder(n.info);
			LinkStrand answer = new LinkStrand(s.reverse().toString());

			answer.myFirst.next = answer1.myFirst;
			answer1 = answer;

			n = n.next;
		}
		answer1.myAppends = myAppends;
		answer1.mySize = mySize;
		return answer1;
	}

	@Override
	/**
	 * Returns the number of times a new node was appended
	 * @return the number of new nodes = myAppends
	 */
	public int getAppendCount() {
		// TODO Auto-generated method stub
		return myAppends;
	}

	@Override
	/**
	 * Returns the character in the LinkStrand at a particular index
	 * @param index is the index of the desired character in the LinkStrand
	 * @return the character in the LinkStrand at the index
	 */
	public char charAt(int index) {
		// TODO Auto-generated method stub
		if (myIndex>index)
		{
			myIndex=0;
			myLocalIndex=0;
			myCurrent = myFirst;
		}
		if (index==0)
			return myCurrent.info.charAt(0);
		if (index>=mySize||index<0)
			throw new IndexOutOfBoundsException();

		while (myIndex != index) {
			myIndex++;
			myLocalIndex++;
			if (myCurrent==null)
				return 'n';
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}

		return myCurrent.info.charAt(myLocalIndex);
	}
	/**
	 * Returns a String representation of the LinkStrand
	 * @return String of LinkStrand with all nodes put together
	 */
	public String toString()
	{
		if (myFirst==null)
			return "";
		Node n = myFirst;
		StringBuilder s = new StringBuilder(myFirst.info);
		n = n.next;
		while (n!=null)
		{
			s.append(n.info);
			n = n.next;
		}
		return s.toString();

	}

}
