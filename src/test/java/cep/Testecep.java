package cep;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Testecep {
    WebDriver driver;

    @Test
    public void Cep() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("endereco")).sendKeys("06695305");
        driver.findElement(By.xpath("//*[@id=\"btn_pesquisar\"]")).click();
        String texto = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
        Assert.assertEquals("Texto invalido", "Alameda Vicente Cocozza", texto);

    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }

    }

