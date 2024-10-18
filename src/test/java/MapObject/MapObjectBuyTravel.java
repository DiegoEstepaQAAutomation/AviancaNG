package MapObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AviancaBase.ClaseBase;

public class MapObjectBuyTravel extends ClaseBase
{
	
	public MapObjectBuyTravel(WebDriver driver) 
	{
		
		super(driver);
		this.driver = driver;
		
		
	}
	
	
	
	
	protected By btnOrigin = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/input[1]");

	////input[@id='pbDestino_6803']
	
	
	protected By OneDate = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[6]");
	
	
	
	
	protected By DestinyDate = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[3]/div[19]");
	//*[@id="pbOrigen_16339"]
	
	protected By Arrival = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/input[1]");
	
	
	protected By Departure = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[1]/label[1]/div[1]/div[1]/input[1]");
	
	protected By btnDestiny = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[3]/div[4]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[2]/div[2]/div[1]/label[1]/div[1]/input[1]");
	
	
	protected By BtnPlus = By.xpath("//*[@id=\"ida_regreso_1_1214901574\"]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[2]/div[1]/div[2]/div[3]");
	
	
	
	protected By btnCantPasajeros = By.xpath("//*[@id='pbPasajeros_1_1214901574']");
	
	

}
