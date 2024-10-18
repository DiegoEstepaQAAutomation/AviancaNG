package PagObject;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapObject.MapObjectBuyTravel;

public class PagObjectTravel extends MapObjectBuyTravel
{
	
	
	public  String avianca ;
	
	


	public String getavianca() {
		return avianca;
	}

	public void setavianca(String avianca) {
		this.avianca = avianca;
	}
	
	
	public PagObjectTravel(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}

	public void urlAcceso() 
	{
		driver.get(avianca);
		
	}
	
	public String CompraViaje(String generarEvidencia,String Origen,String Destino,String FechaSalida,String FechaVuelta,File rutaCarpeta) throws Exception 
	{
		try 
		{
		tiempoEspera(9000);
		//driver.switchTo().alert().dismiss();
		click(btnOrigin, rutaCarpeta,generarEvidencia);
		
		sendkey(Origen,btnOrigin,rutaCarpeta,generarEvidencia);
		//Click por coordenadas
		
		sendkey(Destino,btnDestiny,rutaCarpeta,generarEvidencia);
		//Click por coordenadas 
		
		click(Departure,rutaCarpeta,generarEvidencia);
		
		tiempoEspera(2000);
		
		click(OneDate,rutaCarpeta,generarEvidencia);
		
		click(Arrival,rutaCarpeta,generarEvidencia);
		
		click(DestinyDate,rutaCarpeta,generarEvidencia);
		
		
		}
		catch (Exception e) 
		{
		System.out.println(e);
	}
	String valor = capturarValorSelenium(btnOrigin);
	return valor;

	}
}
