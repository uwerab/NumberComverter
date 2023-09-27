package rwa.ac.auca.numberconverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number=req.getParameter("baseTen");
        String convType=req.getParameter("convType");
        String result = "";
        String message = "";
        System.out.println("your number"+number);
        System.out.println("your Convert Type is "+convType);
        if("binary".equals(convType)){
             result=Integer.toBinaryString(Integer.parseInt(number));
            message="binary";
        } else if ("hexa".equals(convType)) {
            result = Integer.toHexString(Integer.parseInt(number));
            message = "Hexadecimal";
        } else if ("octa".equals(convType)) {
            result = Integer.toOctalString(Integer.parseInt(number));
            message = "octal";
        }
        req.setAttribute("result",result);
        req.setAttribute("message",message);
        req.setAttribute("number",number);
        req.getRequestDispatcher("Converter.jsp").forward(req, resp);
    }
}
