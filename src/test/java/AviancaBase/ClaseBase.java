package AviancaBase;

import java.awt.Robot;
import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenerarReportePdf;

public class ClaseBase 
{
	
protected WebDriver driver;
	
	
	String rutaOutput;
	
	  
	  



	
	
 // public String getRutaOutut() {
	//	return rutaOutut;
	//}


	public void setRutaOutut(String rutaOutput) {
		this.rutaOutput = rutaOutput;
	}


public ClaseBase(WebDriver driver)
  
  {
	  super();
	}
  
  
//METODO DE NAVEGADOR
  public static WebDriver chromeDriverConnection() {

      WebDriver _driver = null;
      try {
      //SETEAR LAS OPCIONES DE NAVEGADOR
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

      //SETEAR LAS PROPIEDADES DEL NAVEGADOR
      System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
      _driver = new ChromeDriver();

      //MAXIMIZAR NAVEGADOR
      _driver.manage().window().maximize();
      return _driver;
      } catch (Exception e) {
          System.out.println(e);
      }
      return _driver;
  }
  
	// METODO CLICK

	public void click(By locator, File rutaCarpeta,String generarEvidencia) throws Exception
	{
		try
		{

		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta,generarEvidencia,locator);
		
		} 
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	
		
		
	}
	
	
	//METODO ALERTAS
	public void clickDato(By locator) throws Exception 
	{
		driver.findElement(locator).click();
		tiempoEspera(2000);
		
	}
	
	// METODO BORRAR

	public void borrar(By locator, File rutaCarpeta,String generarEvidencia) throws Exception
	{
		try
		{

		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta,generarEvidencia,locator);
		} 
		
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}
	
	
	// METODO ENVIAR TEXTO

	public void sendkey(String inputText, By locator, File rutaCarpeta,String generarEvidencia) throws Exception 
	{
		try
		{
	
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta,generarEvidencia,locator);
		}
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}

	
	
	public String capturarValorSelenium(By locator) throws Exception 
	{
		String valor = driver.findElement(locator).getText();
		return valor;
	}
	// METODO ENTER SUBMIN

	public void submit(By locator, File rutaCarpeta,String generarEvidencia) throws Exception 
	{
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta,generarEvidencia,locator);
	}

	// METODO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}
	
	
	//IMPORTANTE ESTA ESTATICA -VALIDAR FUNCIONAMIENTO ASI

	public static String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String HoraSistema() {

		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	public void captureScreen(File rutaCarpeta,String generarEvidencia,By locator) throws Exception { 
	
	
	//if(generarEvidencia.equals("Si"))
	//{
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
		
		String rutaImagen = new File(rutaCarpeta + "\\"+hora + ".png").toString();
		
		//INSTANCIAR LA CLASE GENERAL PDF
		GenerarReportePdf informePdf = new GenerarReportePdf(); 
		
		informePdf.crearbody(locator, rutaImagen);
		
		
		eliminarArchivo(rutaImagen);
		
		
	
	//}
	
		
		
		
	}
	
	
	
	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception 
	{
		if (generarEvidencia.equals("Si"))
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			//INSTACIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearbodyError(locator,rutaImagen,msnError);
			//ELIMINAR IMAGEN CREADA
			
			eliminarArchivo(rutaImagen);
			}
		}
	
	
	
	public void eliminarArchivo(String rutaImagen) 
	{
		
		
		File fichero = new File(rutaImagen);
		fichero.delete();
		
		
		
	}
		
	
	
 
	//METODO ESTATICO OJO
	public File crearCarpeta(String nomTest) 
	{
		//ALCACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File(rutaOutput+nomCarpeta);
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	// METODO INICIAL

	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();

	}
	
	//METODO DE SCROLL
			public void scrollpage(int x,int y) 
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				 js.executeScript("window.scrollBy(x,y)");
			}
			
			// METODO CONTROLA
			
						public void controla(By locator, File rutaCarpeta,String generarEvidencia) throws Exception {
							driver.findElement(locator).sendKeys(Keys.CONTROL,"a");
							captureScreen(rutaCarpeta,generarEvidencia,locator);
						}
						
						// METODO TECLA BORRAR
						
						public void teclaborrar(By locator, File rutaCarpeta,String generarEvidencia) throws Exception {
							
							driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
							captureScreen(rutaCarpeta,generarEvidencia,locator);
						}
		
						// METODO INTRO
						
						public void intro(By locator, File rutaCarpeta,String generarEvidencia) throws Exception 
						{
							driver.findElement(locator).sendKeys(Keys.ENTER);
							captureScreen(rutaCarpeta,generarEvidencia,locator);
						}
						
						// METODO INTERACTUAR ALERTA
						
						
						public void alert() {
							try {
							WebDriverWait wait = new WebDriverWait(driver, 20);
							wait.until(ExpectedConditions.alertIsPresent());
							Alert alert = driver.switchTo().alert();
							alert.accept();
							tiempoEspera(3000);
							} catch (Exception e) {
							System.out.println(e);
							}
						}


}
