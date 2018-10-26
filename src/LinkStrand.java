
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
	public LinkStrand()
	{
		this("");
	}
	
	public LinkStrand(String s)
	{
		initialize(s);
	}
	@Override
	public long size() {
		// TODO Auto-generated method stub
		return mySize;
	}

	@Override
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
	public IDnaStrand getInstance(String source) {
		// TODO Auto-generated method stub
		return new LinkStrand(source);
	}

	@Override
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
	public IDnaStrand reverse() {
		// TODO Auto-generated method stub
		if (myFirst==null)
			return new LinkStrand();
		
		Node n = myFirst;
		StringBuilder s = new StringBuilder(myFirst.info);
		LinkStrand answer1 = new LinkStrand(s.reverse().toString());
		n=n.next;
		if (n!=null)
			answer1.myLast = answer1.myFirst;
		while (n!=null)
		{
			s = new StringBuilder(n.info);
			LinkStrand answer = new LinkStrand(s.reverse().toString());
			
			answer.myFirst.next = answer1.myFirst;
			answer.myLast = answer1.myLast;
			answer1 = answer;
			n = n.next;
		}
		
		return answer1;
	}

	@Override
	public int getAppendCount() {
		// TODO Auto-generated method stub
		return myAppends;
	}

	@Override
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
	
	public String toString()
	{
		if (myFirst==null)
			return "";
		if (myLast == null)
			return myFirst.info;
		Node n = myFirst;
		StringBuilder s = new StringBuilder(myFirst.info);
		n = n.next;
		while (n!=myLast)
		{
			s.append(n.info);
			n = n.next;
		}
		s.append(myLast.info);
		return s.toString();
		
	}

}
