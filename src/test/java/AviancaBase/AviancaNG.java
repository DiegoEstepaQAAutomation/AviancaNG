package AviancaBase;

import org.testng.annotations.Test;


import PagObject.PagObjectTravel;
import Utilities.GenerarReportePdf;
import Utilities.MyScreenRecorder;
import Utilities.ExcelUtilidades;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AviancaNG 
{
	
	
	private WebDriver driver;
	
	
	PagObjectTravel travel;
	
	ClaseBase base;
	
	
	File rutaCarpeta = null;
	
	GenerarReportePdf reporte;
	
	String valor;
	  @BeforeClass
	  @Parameters({"avianca","rutaOutput","rutaImagenReporte"})
  public void beforeClass(@Optional("default") String avianca,@Optional("default")String rutaOutput,@Optional("default")String rutaImagenReporte) 
	  
	  {
		    driver =ClaseBase.chromeDriverConnection();
			
			base = new ClaseBase(driver);
			
			reporte = new GenerarReportePdf();
			
			travel = new PagObjectTravel(driver);
			
			reporte.setRutaImagen(rutaImagenReporte);
			
			
			base.setRutaOutut(rutaOutput);
			
			travel.setavianca(avianca);
			
			
		  
	  }

	
	
	
  @Test(dataProvider = "Search")
  public void ComprarTicket(String Ejecutar,String GenerarEvidencia,String Origen,String Destino,String FechaSalida,String FechaVuelta) throws Exception 
  {
	  if(Ejecutar.equals("SI")) 
	  {
		  
		  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
		   File rutaCarpeta = base.crearCarpeta(nomTest);																	
		   
		   travel.urlAcceso();
		   
		   if(GenerarEvidencia.equals("SI")) 
		   {
			   
			   
			   	rutaCarpeta = base.crearCarpeta(nomTest);
				  
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				reporte.crearPlantilla(nomTest,rutaCarpeta);
				
	      	  	valor=travel.CompraViaje(GenerarEvidencia, Origen, Destino, FechaSalida, FechaVuelta, rutaCarpeta);
				
			   
				 MyScreenRecorder.stopRecording();
				  
				 reporte.cerrarPlantilla();
				 
				 
				 
				
		   }else 
		   {
			   
			   valor= travel.CompraViaje(GenerarEvidencia, Origen, Destino, FechaSalida, FechaVuelta, rutaCarpeta);
			   
			   
		   }
		   
		   
		   
		   
		   
		   //assert valor.contains(Department);
   
		
		  
		  
	  }
	  
	
	  

	  
  }
  
  
  @DataProvider(name="Search")
  public Object [][] datos() throws Exception 
  {
	  Object [][] arreglo=ExcelUtilidades.getTableArray("./Data/DatosdeViaje.xlsx","Hoja1");
		
		
	  return arreglo;
  }
  
  
  
  

  @AfterClass
  public void afterClass() 
  {
	  //driver.close();
  }

}
