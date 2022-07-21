package com.bruno.alura.stickes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeneratorFigurines {

	public void createFigurines(InputStream inputStream,String fileName) throws IOException {

		// leitura da imagem
		
		//	InputStream inputStream = new FileInputStream(new File("C:\\Users\\bruno.alves\\Desktop\\filme-bumblebee.jpg"));
		
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();

		BufferedImage imageOrigin = ImageIO.read(inputStream);

		// criar nova imagem em memoria com transparencia e com tamanho novo

		int largura = imageOrigin.getWidth();
		int altura = imageOrigin.getHeight();

		int novaAltura = altura + 200;

		BufferedImage newImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar a imagem original para nova imagem (em memorai)

		Graphics2D graphics = (Graphics2D) newImage.getGraphics();

		graphics.drawImage(imageOrigin, 0, 0, null);

		// configurar a fonte

		var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		
		graphics.setFont(font);
		
		graphics.setColor(Color.YELLOW);

		// escrever uma frase na nova imagem

		graphics.drawString("TOPZERA", 150, novaAltura - 100);

		// escreve a nova imagem em um arquivo

		ImageIO.write(newImage, "png", new File("C:\\Users\\bruno.alves\\Desktop\\"+fileName));

	}

}
