package google;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTeste {// Abertura da classe.
    WebDriver driver; // Criar fora da classe para execultar para todos os testes.

    @Test // Para iniciar o teste.

    public void testeGoogle() throws InterruptedException {// Abertura do Metodo.
        driver = new ChromeDriver(); // Instanciar ( Chamar Driver ).
        driver.get("https://www.google.com"); // Acessar o navegador
        driver.manage().window().maximize(); // Menssagem para maximizar a tela
        driver.findElement(By.name("q")).sendKeys("São paulo"); // Busca do elemento
        Thread.sleep(2000);   // espera explixida ( Tempo - Aguardar ). Caso apresente um erro devido não ter encontrado, pode ser por questão de tempo.
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[3]/div/div[2]/div[1]/span/b")).click(); // Para clicar no objeto
        String texto = driver.findElement(By.xpath("//*[@id=\"sports-app\"]/div/div[1]/div/div/div/div")).getText(); // fazer validação pelo accerticols se e verdadeiro.
        Assert.assertEquals("Texto invalido", "São Paulo x Coritiba", texto);
    }// Fechamento do metodo.

    @After // Serve para finalizar todos os teste que tiver o @After.
    public void fecharBrowser() {// Abertura da classe.
        driver.quit();
    } // Fechamento da classe.
}// Fechamento da classe.