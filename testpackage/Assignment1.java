package testpackage;

public class InvoiceItem_Demo {
	
	
	
	private int  InvoiceId;
	private String InvoiceDesc;
	private static int InvoiceQty;
	private static double InvoiceItemPrice;	
	
		
	public int getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		InvoiceId = invoiceId;
	}
	public String getInvoiceDesc() {
		return InvoiceDesc;
	}
	public void setInvoiceDesc(String invoiceDesc) {
		InvoiceDesc = invoiceDesc;
	}
	public int getInvoiceQty() {
		return InvoiceQty;
	}
	public void setInvoiceQty(int invoiceQty) {
		InvoiceQty = invoiceQty;
	}
	public double getInvoiceItemPrice() {
		return InvoiceItemPrice;
	}
	public void setInvoiceItemPrice(double invoiceItemPrice) {
		InvoiceItemPrice = invoiceItemPrice;
	}
	
	public InvoiceItem_Demo(int invoiceId, String invoiceDesc, int invoiceQty, double invoiceItemPrice) {
		super();
		InvoiceId = invoiceId;
		InvoiceDesc = invoiceDesc;
		InvoiceQty = invoiceQty;
		InvoiceItemPrice = invoiceItemPrice;
	}
	
	public static void main(String[] args) {
	
	try {
		if(InvoiceQty ==  1) {
			 System.out.println("InvoiceItemPrice is :: " + InvoiceItemPrice);
		}
		else if (InvoiceQty > 1) {
		    
		    double totalPrice = InvoiceItemPrice * InvoiceQty;       
		    System.out.println("InvoiceItemPrice" + totalPrice);
		} else {
		    System.out.println("InvoiceQty is 1 or less.");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

	
		

	


