package oopsOneWithConditionsOne;

public class UseNovel 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Novel n1 = new Novel(), n2 = new Novel(), n3 = new Novel();
		Novel N[] = {n1, n2, n3};
		int sum = 0;
		boolean isSame = true;
		
		n1.setAuthor("George Corwell");
		n1.setTitle("Animal Farm");
		n1.setPrice(200);
		n1.setPages(80);
		n1.setId(1989);
		
		n2.setAuthor("J. K. Rowling");
		n2.setTitle("Harry Potter");
		n2.setPrice(500);
		n2.setPages(450);
		n2.setId(203);
		
		n3.setAuthor("Chetan Bhagat");
		n3.setTitle("Two States");
		n3.setPrice(400);
		n3.setPages(250);
		n3.setId(144);
		
		for (Novel n : N) {
			System.out.println(n.getAuthor() + " " + n.getTitle()
					+ " " + n.getPrice() + " " + n.getId()
					+ " " + n.getPages());
			
			sum += n.getPrice();
			if(!n.getAuthor().equals(N[0].getAuthor()))
				isSame = false;
		}
		
		System.out.println("Total price is " + sum);
		
		if(isSame)
			System.out.print("SAME AUTHOR");
		else
			System.out.print("DIFFERENT AUTHORS");
	}

}

class Novel
{
	private String author, title;
	private int price, pages, id;
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getPages()
	{
		return pages;
	}
	
	public int getId()
	{
		return id;
	}
}