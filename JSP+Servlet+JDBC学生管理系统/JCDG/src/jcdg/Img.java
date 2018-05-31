package jcdg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Img
 */
public class Img extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Img() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedImage buffe=new BufferedImage(250, 50,BufferedImage.TYPE_INT_RGB);
		Graphics g=buffe.getGraphics();
		g.setColor(RondomTool.getRandomColor());
		g.setFont(new Font("黑体",Font.BOLD,20));
		g.fillRect(0, 0, 250,50); 
		char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		Random r=new Random();
		int len=ch.length;
		int index; 
		StringBuffer vale=new StringBuffer();
		for(int i=0;i<4;i++) {
			index=r.nextInt(len);
			g.setColor(RondomTool.getRandomColor());
		    g.setColor(new Color(r.nextInt(80),r.nextInt(127),r.nextInt(255)));  
		    g.drawString(ch[index]+"",50+30*i, 30+5*i);
		    g.drawLine(r.nextInt(80), r.nextInt(100), r.nextInt(150), r.nextInt(180));
		    vale.append(ch[index]);
		}
		request.getSession().setAttribute("piccode",vale.toString()); 
		ImageIO.write(buffe, "JPG", response.getOutputStream()); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
