package vn.myclass.login;

import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.web.SocketServerController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;

@WebServlet(urlPatterns = {"/login.html","/logout.html"})
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        UserService userService = new UserServiceImpl();


        if(command.getTypeUrl() !=null && command.getTypeUrl().equals(WebConstant.LOGIN)){
            try {
                if (userService.isUserExist(pojo) != null) {
                    session.setAttribute("user", pojo.getName());
                    response.sendRedirect("/home");
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
                    rd.forward(request, response);
                }
            } catch (NullPointerException e) {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên hoặc mật khẩu sai");
                RequestDispatcher rd = request.getRequestDispatcher("/views/login/login.jsp");
                rd.forward(request, response);
            }
        } else if (command.getTypeUrl() != null && command.getTypeUrl().equals(WebConstant.LOGOUT)){
            session.removeAttribute("user");
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(request, response);
        }
    }

   // mo Server

}