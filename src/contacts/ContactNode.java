package contacts;

public class ContactNode
{
	private String contactName;
	private String contactPhoneNumber;
	private ContactNode nextNodePtr;
	
	
	
	/**
	 * Constructor - ContactNode
	 *
	 * @param contactName
	 * @param contactPhoneNumber
	 * @param nextNodePtr
	 */
	public ContactNode(String contactName, String contactPhoneNumber)
	{	
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public ContactNode()
	{
		this.setContactName("");
		this.setContactPhoneNumber("");
		this.setNext(null);
	}

	public void insertAfter(ContactNode currNode)
	{
		ContactNode tempNext;
		
		tempNext = this.getNext(); 
		this.setNext(currNode);
		currNode.setNext(tempNext);
	}
	
	public void printContactNode()
	{
		System.out.printf("Name: %s\n" + 
				"Phone number: %s\n", this.getName(), this.getPhoneNumber());
	}
	
	/**
	 * Field getter
	 * 
	 * @return the contactName
	 */
	public String getName()
	{
		return contactName;
	}

	/**
	 * Field getter
	 * 
	 * @return the contactPhoneNumber
	 */
	public String getPhoneNumber()
	{
		return contactPhoneNumber;
	}

	/**
	 * Field getter
	 * 
	 * @return the nextNodePtr
	 */
	public ContactNode getNext()
	{
		return nextNodePtr;
	}

	/**
	 * Field setter
	 * 
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	/**
	 * Field setter
	 * 
	 * @param contactPhoneNumber the contactPhoneNumber to set
	 */
	public void setContactPhoneNumber(String contactPhoneNumber)
	{
		this.contactPhoneNumber = contactPhoneNumber;
	}

	/**
	 * Field setter
	 * 
	 * @param nextNodePtr the nextNodePtr to set
	 */
	public void setNext(ContactNode nextNodePtr)
	{
		this.nextNodePtr = nextNodePtr;
	}

}
