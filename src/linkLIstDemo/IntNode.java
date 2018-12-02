/*
* Assignment	linkLIstDemo
* Program		IntNode
* date			Oct 19, 2018
* Author		Jorge Jimenez
*/
package linkLIstDemo;

//===== Code from file IntNode.java =====
public class IntNode
{
	private int dataVal;
	private IntNode nextNodePtr;

	public IntNode(int dataInit, IntNode nextLoc)
	{
		this.dataVal = dataInit;
		this.nextNodePtr = nextLoc;
	}

	public IntNode(int dataInit)
	{
		this.dataVal = dataInit;
		this.nextNodePtr = null;
	}

	/*
	 * Insert node after this node. Before: this -- next After: this -- node -- next
	 */
	public void insertAfter(IntNode nodePtr)
	{
		IntNode tmpNext;

		tmpNext = this.nextNodePtr; // Remember next
		this.nextNodePtr = nodePtr; // this -- node -- ?
		nodePtr.nextNodePtr = tmpNext; // this -- node -- next
	}

	// Grab location pointed by nextNodePtr
	public IntNode getNext()
	{
		return this.nextNodePtr;
	}

	public int getDataVal()
	{
		return this.dataVal;
	}
}
//===== end =====
